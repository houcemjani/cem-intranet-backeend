package com.ads.Investigationintranet.persistence.implementation.mongo;

import com.ads.Investigationintranet.persistence.generic.entities.OrderBy;
import com.ads.Investigationintranet.persistence.generic.entities.OrderByClause;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpression;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpressionField;
import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;
import com.ads.Investigationintranet.persistence.generic.stereotypes.Configuration;
import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.introspect.VisibilityChecker;
import com.mongodb.*;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSFile;
import com.mongodb.util.JSON;
import org.apache.commons.lang3.StringUtils;
import org.bson.types.ObjectId;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.net.UnknownHostException;
import java.util.*;

public class MongoImplementationManager implements MongoManager {
    private static final String MONGO_URI = "app.persistence.configuration.mongo.uri";
    private static final String MONGO_DBNAME = "app.persistence.configuration.mongo.dbname";
    private static final String ID = "_id";
    private static final String ID_3H = "hhhId";
    private ThreadLocal<Map<ObjectId, Object>> cache;
    private DB db;
    private ObjectMapper jsonMapper;
    private RefConverter refConverter;

    public MongoImplementationManager() {
        this((Configuration)null);
    }

    public MongoImplementationManager(Configuration appConfiguration) {
        this.cache = new ThreadLocal();
        this.refConverter = RefConverter.INSTANCE;
        this.jsonMapper = new ObjectMapper();
        VisibilityChecker<?> noAutoDetect = this.jsonMapper.getSerializationConfig().getDefaultVisibilityChecker().with(Visibility.NONE);
        this.jsonMapper.setVisibilityChecker(noAutoDetect);
        String uri = get(appConfiguration, "app.persistence.configuration.mongo.uri");

        MongoClient mongo;
        try {
            if (StringUtils.isEmpty(uri)) {
                mongo = new MongoClient();
            } else {
                MongoClientURI mongoUri = new MongoClientURI(uri);
                mongo = new MongoClient(mongoUri);
            }
        } catch (UnknownHostException var6) {
            throw new IllegalArgumentException(var6);
        }

        String dbName = get(appConfiguration, "app.persistence.configuration.mongo.dbname");
        this.db = dbName != null ? mongo.getDB(dbName) : null;
        this.clearCache();
    }

    private static String get(Configuration conf, String key) {
        return conf != null ? conf.get(key) : null;
    }

    public Object persist(Object o) throws PersistException {
        return this.persist(o, true);
    }

    public List<Object> persistList(List<Object> objects) throws PersistException {
        return null;
    }

    private Object persist(Object o, boolean clearCahce) throws PersistException {
        if (clearCahce) {
            this.clearCache();
        }

        Objects.requireNonNull(o);
        Class<?> myClass = o.getClass();
        HHHIdentifiable hhh = (HHHIdentifiable)o;
        long hhhId = hhh.getHhhId();
        boolean isNew = hhhId == 0L;
        ObjectId id;
        if (isNew) {
            id = this.refConverter.createObjectId(myClass);
            hhhId = this.refConverter.toHhhId(id);
            hhh.setHhhId(hhhId);
        } else {
            id = this.refConverter.toObjectId(myClass, hhhId);
        }

        try {
            String json = this.jsonMapper.writeValueAsString(o);
            DBObject dbObject = (DBObject)JSON.parse(json);
            dbObject.removeField("hhhId");
            dbObject.put("_id", id);
            this.putReferences(dbObject, o);
            if (!this.isFileDescription(myClass)) {
                DBCollection collection = this.getCollection(myClass);
                if (isNew) {
                    collection.insert(new DBObject[]{dbObject});
                } else {
                    collection.update(new BasicDBObject("_id", id), dbObject);
                }
            } else {
                GridFS gridFs = this.getFileCollection(myClass);
                Object gridFsFile;
                if (isNew) {
                    gridFsFile = gridFs.createFile(this.getInputStream(o), this.getFilename(o), true);
                    ((GridFSFile)gridFsFile).put("_id", id);
                } else {
                    gridFsFile = gridFs.find(id);
                }

                ((GridFSFile)gridFsFile).setMetaData(dbObject);
                ((GridFSFile)gridFsFile).put("contentType", this.getContentType(o));
                Date uploadDate = this.getUploadDate(o);
                if (uploadDate != null) {
                    ((GridFSFile)gridFsFile).put("uploadDate", uploadDate);
                } else {
                    uploadDate = ((GridFSFile)gridFsFile).getUploadDate();
                    this.setUploadDate(o, uploadDate);
                }

                ((GridFSFile)gridFsFile).save();
            }

            return o;
        } catch (MongoException | JsonProcessingException var14) {
            throw new PersistException(var14);
        }
    }

    private List<Field> getMongo3hAnnotatedFields(Class<?> myClass) {
        List<Field> result = new ArrayList();

        for(Class clazz = myClass; clazz != null && clazz != Object.class; clazz = clazz.getSuperclass()) {
            Field[] arr$ = clazz.getDeclaredFields();
            int len$ = arr$.length;

            for(int i$ = 0; i$ < len$; ++i$) {
                Field field = arr$[i$];
                MongoReference reference = (MongoReference)field.getAnnotation(MongoReference.class);
                if (reference != null) {
                    field.setAccessible(true);
                    result.add(field);
                }
            }
        }

        return result;
    }

    private void putReferences(DBObject dbObject, Object o) throws PersistException {
        try {
            Iterator i$ = this.getMongo3hAnnotatedFields(o.getClass()).iterator();

            while(true) {
                String name;
                Iterable objects;
                do {
                    while(true) {
                        Field field;
                        Object object;
                        do {
                            if (!i$.hasNext()) {
                                return;
                            }

                            field = (Field)i$.next();
                            name = field.getName();
                            object = field.get(o);
                        } while(object == null);

                        if (Iterable.class.isAssignableFrom(field.getType())) {
                            objects = (Iterable)field.get(o);
                            break;
                        }

                        HHHIdentifiable hhh = (HHHIdentifiable)object;
                        ObjectId objectId = this.refConverter.getObjectId(hhh);
                        if (objectId == null) {
                            this.persist(object, false);
                            objectId = this.refConverter.getObjectId(hhh);
                        }

                        dbObject.put(name, objectId);
                    }
                } while(objects == null);

                BasicDBList list = new BasicDBList();

                ObjectId objectId;
                for(Iterator i2$ = objects.iterator(); i2$.hasNext(); list.add(objectId)) {
                    Object element = i2$.next();
                    HHHIdentifiable hhh = (HHHIdentifiable)element;
                    objectId = this.refConverter.getObjectId(hhh);
                    if (objectId == null) {
                        this.persist(element, false);
                        objectId = this.refConverter.getObjectId(hhh);
                    }
                }

                dbObject.put(name, list);
            }
        } catch (ReflectiveOperationException var13) {
            throw new AssertionError(var13);
        }
    }

    private DBObject cutReferences(DBObject dbObject, Class<?> myClass) {
        DBObject result = new BasicDBObject();
        Iterator i$ = this.getMongo3hAnnotatedFields(myClass).iterator();

        while(i$.hasNext()) {
            Field field = (Field)i$.next();
            String name = field.getName();
            MongoReference reference = (MongoReference)field.getAnnotation(MongoReference.class);
            if (reference != null) {
                result.put(name, dbObject.removeField(name));
            }
        }

        return result;
    }

    private void resolveReferences(Object o, DBObject dbObject) {
        try {
            Iterator i$ = this.getMongo3hAnnotatedFields(o.getClass()).iterator();

            while(i$.hasNext()) {
                Field field = (Field)i$.next();
                String name = field.getName();
                MongoReference reference = (MongoReference)field.getAnnotation(MongoReference.class);
                if (reference != null) {
                    if (Iterable.class.isAssignableFrom(field.getType())) {
                        BasicDBList list = (BasicDBList)dbObject.get(name);
                        if (list != null) {
                            Type type = ((ParameterizedType)field.getGenericType()).getActualTypeArguments()[0];
                            LazyMongoList lazyList = new LazyMongoList(this, list, (Class)type);
                            field.set(o, lazyList);
                        }
                    } else {
                        ObjectId objectId = (ObjectId)dbObject.get(name);
                        long hhhId = this.refConverter.toHhhId(objectId);
                        if (hhhId != 0L) {
                            field.set(o, this.retrieve(field.getType(), hhhId, false));
                        }
                    }
                }
            }

        } catch (ReflectiveOperationException var10) {
            throw new AssertionError(var10);
        } catch (NoSuchObjectException var11) {
            throw new IllegalStateException(var11);
        }
    }

    public <P> List<P> resolveReferences(BasicDBList list, Class<P> myClass) {
        ArrayList result = new ArrayList(list.size());

        try {
            Iterator i$ = list.iterator();

            while(i$.hasNext()) {
                Object objectId = i$.next();
                long hhhId = this.refConverter.toHhhId((ObjectId)objectId);
                result.add(this.retrieveTyped(myClass, hhhId));
            }

            return result;
        } catch (NoSuchObjectException var8) {
            throw new IllegalStateException(var8);
        }
    }

    private boolean isFileDescription(Class<?> myClass) {
        return this.getFileDescription(myClass) != null;
    }

    private MongoFileDescription getFileDescription(Class<?> myClass) {
        return (MongoFileDescription)myClass.getAnnotation(MongoFileDescription.class);
    }

    private InputStream getInputStream(Object o) {
        String name = this.getFileDescription(o.getClass()).inputStream();
        return (InputStream)this.get(o, name);
    }

    private void setInputStream(Object o, InputStream in) {
        String name = this.getFileDescription(o.getClass()).inputStream();
        this.set(o, name, in);
    }

    private String getFilename(Object o) {
        String name = this.getFileDescription(o.getClass()).filename();
        return (String)this.get(o, name);
    }

    private void setFilename(Object o, String filename) {
        String name = this.getFileDescription(o.getClass()).filename();
        this.set(o, name, filename);
    }

    private String getContentType(Object o) {
        String name = this.getFileDescription(o.getClass()).contentType();
        return (String)this.get(o, name);
    }

    private void setContentType(Object o, String contentType) {
        String name = this.getFileDescription(o.getClass()).contentType();
        this.set(o, name, contentType);
    }

    private Date getUploadDate(Object o) {
        String name = this.getFileDescription(o.getClass()).uploadDate();
        return (Date)this.get(o, name);
    }

    private void setUploadDate(Object o, Date uploadDate) {
        String name = this.getFileDescription(o.getClass()).uploadDate();
        this.set(o, name, uploadDate);
    }

    private Object get(Object o, String property) {
        if (StringUtils.isEmpty(property)) {
            return null;
        } else {
            String methodName = this.getter(property);

            try {
                return o.getClass().getMethod(methodName).invoke(o);
            } catch (NoSuchMethodException var5) {
                throw new AssertionError(var5);
            } catch (ReflectiveOperationException var6) {
                throw new AssertionError(var6);
            }
        }
    }

    private String getter(String property) {
        return "get" + Character.toUpperCase(property.charAt(0)) + property.substring(1);
    }

    private void set(Object o, String property, Object value) {
        if (!StringUtils.isEmpty(property)) {
            String getter = this.getter(property);
            String methodName = "s" + getter.substring(1);

            try {
                Class<?> type = o.getClass().getMethod(getter).getReturnType();
                o.getClass().getMethod(methodName, type).invoke(o, value);
            } catch (NoSuchMethodException var7) {
                throw new AssertionError(var7);
            } catch (ReflectiveOperationException var8) {
                throw new AssertionError(var8);
            }
        }
    }

    private DBCollection getCollection(Class<?> myClass) {
        return this.db.getCollection(this.getCollectionName(myClass));
    }

    private GridFS getFileCollection(Class<?> myClass) {
        return new GridFS(this.db, this.getCollectionName(myClass));
    }

    private String getCollectionName(Class<?> myClass) {
        return myClass.getName();
    }

    public <P> P retrieve(Class myClass, long hhhId) throws NoSuchObjectException {
        return this.retrieve(myClass, hhhId, true);
    }

    public <P> P retrieve(Class myClass, long hhhId, boolean clearCache) throws NoSuchObjectException {
        if (clearCache) {
            this.clearCache();
        } else {
            this.initCacheIfNeeded();
        }

        return (P)this.retrieveTyped(myClass, hhhId);
    }

    private void initCacheIfNeeded() {
        if (this.cache.get() == null) {
            this.clearCache();
        }

    }

    private <P> P retrieveTyped(Class<P> myClass, long hhhId) throws NoSuchObjectException {
        BasicDBObject query = new BasicDBObject("_id", this.refConverter.toObjectId(myClass, hhhId));
        DBObject one = !this.isFileDescription(myClass) ? this.getCollection(myClass).findOne(query) : this.getFileCollection(myClass).findOne(query);
        if (one == null) {
            throw new NoSuchObjectException(myClass.getSimpleName() + ":" + hhhId);
        } else {
            return this.toDomain(myClass, (DBObject)one);
        }
    }

    private <P> P toDomain(Class<P> myClass, DBObject dbObject) {
        boolean isFileDescription = this.isFileDescription(myClass);
        DBObject bson = !isFileDescription ? dbObject : ((GridFSDBFile)dbObject).getMetaData();
        ObjectId id = (ObjectId)bson.removeField("_id");
        Object cached = ((Map)this.cache.get()).get(id);
        if (cached != null) {
            if (cached.getClass().equals(myClass)) {
                return (P)cached;
            }

            this.clearCache();
        }

        bson.put("hhhId", this.refConverter.toHhhId(id));
        DBObject references = this.cutReferences(bson, myClass);

        Object domain;
        try {
            domain = this.jsonMapper.readValue(JSON.serialize(bson), myClass);
            ((Map)this.cache.get()).put(id, domain);
        } catch (IOException var10) {
            throw new IllegalStateException(var10);
        }

        this.resolveReferences(domain, references);
        if (isFileDescription) {
            GridFSDBFile gridDbFile = (GridFSDBFile)dbObject;
            this.setGridFS(gridDbFile, this.getFileCollection(myClass));
            this.setContentType(domain, gridDbFile.getContentType());
            this.setFilename(domain, gridDbFile.getFilename());
            this.setInputStream(domain, gridDbFile.getInputStream());
            this.setUploadDate(domain, gridDbFile.getUploadDate());
        }

        return (P)domain;
    }

    private void setGridFS(GridFSFile gridDbFile, GridFS fs) {
        try {
            Method method = GridFSFile.class.getDeclaredMethod("setGridFS", GridFS.class);
            method.setAccessible(true);
            method.invoke(gridDbFile, fs);
        } catch (ReflectiveOperationException var4) {
            throw new AssertionError(var4);
        }
    }

    public List<Object> select(Class myClass, SelectCriteriaExpression q, OrderBy orderBy, long offset, long limit) {
        boolean qComplete = q.isComplete();
        boolean orderByComplete = orderBy.isComplete();
        DBCursor cursor;
        if (!this.isFileDescription(myClass)) {
            DBCollection collection = this.getCollection(myClass);
            if (qComplete) {
                cursor = collection.find(this.getQuery(q));
            } else {
                cursor = collection.find();
            }

            if (orderByComplete) {
                cursor = cursor.sort(this.getOrderBy(orderBy));
            }
        } else {
            GridFS fileCollection = this.getFileCollection(myClass);
            if (orderByComplete) {
                DBObject query = qComplete ? this.getFileQuery(q) : new BasicDBObject();
                cursor = fileCollection.getFileList((DBObject)query, this.getOrderBy(orderBy));
            } else if (qComplete) {
                cursor = fileCollection.getFileList(this.getFileQuery(q));
            } else {
                cursor = fileCollection.getFileList();
            }
        }

        if (offset >= 0L) {
            cursor = cursor.skip((int)offset);
        }

        if (limit >= 0L) {
            cursor = cursor.limit((int)limit);
        }

        this.clearCache();
        List<Object> result = new ArrayList();
        Iterator i$ = cursor.iterator();

        while(i$.hasNext()) {
            DBObject dbObject = (DBObject)i$.next();
            result.add(this.toDomain(myClass, dbObject));
        }

        cursor.close();
        return result;
    }

    private DBObject getQuery(SelectCriteriaExpression q) {
        return this.getQuery("", q);
    }

    private DBObject getFileQuery(SelectCriteriaExpression q) {
        DBObject result = this.getQuery("metadata.", q);
        return result;
    }

    private DBObject getQuery(String prefix, SelectCriteriaExpression q) {
        if (!q.isComplete()) {
            return new BasicDBObject();
        } else {
            String operator = q.getOperator();
            SelectCriteriaExpressionField field = q.getField();
            Object value = q.getValue();
            List<SelectCriteriaExpression> subCriteria = q.getSelectCriteriaExpressions();
            Object result;
            if (subCriteria != null && !subCriteria.isEmpty()) {
                result = this.getJoinedQuery(prefix, operator, subCriteria);
            } else if (field != null && value != null) {
                result = this.getSingleQuery(prefix, field, operator, value);
            } else {
                result = new BasicDBObject();
            }

            return (DBObject)result;
        }
    }

    private DBObject getSingleQuery(String prefix, SelectCriteriaExpressionField field, String operator, Object value) {
        String function = field.getFunction();
        if (function != null) {
            throw new UnsupportedOperationException(function);
        } else {
            return this.getSimplePropertyQuery(prefix, field.getName(), this.toComparison(operator), value);
        }
    }

    private BasicDBObject getSimplePropertyQuery(String prefix, String name, String comparison, Object value) {
        return new BasicDBObject(prefix + name, comparison == null ? value : new BasicDBObject(comparison, value));
    }

    private String toComparison(String operator) {
        if (!"=".equals(operator) && !"equal".equals(operator)) {
            if (!">".equals(operator) && !"greaterThan".equals(operator)) {
                if (!">=".equals(operator) && !"greaterThanOrEqualTo".equals(operator)) {
                    if (!"<".equals(operator) && !"lessThan".equals(operator)) {
                        if (!"<=".equals(operator) && !"lessThanOrEqualTo".equals(operator)) {
                            return !"!=".equals(operator) && !"notEqualTo".equals(operator) ? "$" + operator : "$ne";
                        } else {
                            return "$lte";
                        }
                    } else {
                        return "$lt";
                    }
                } else {
                    return "$gte";
                }
            } else {
                return "$gt";
            }
        } else {
            return null;
        }
    }

    private DBObject getJoinedQuery(String prefix, String operator, List<SelectCriteriaExpression> subCriteria) {
        BasicDBObject result = new BasicDBObject();
        BasicDBList values = new BasicDBList();
        Iterator i$ = subCriteria.iterator();

        while(i$.hasNext()) {
            SelectCriteriaExpression subQuery = (SelectCriteriaExpression)i$.next();
            values.add(this.getQuery(prefix, subQuery));
        }

        result.put("$" + operator, values);
        return result;
    }

    private DBObject getOrderBy(OrderBy orderBy) {
        BasicDBObject result = new BasicDBObject();
        Iterator i$ = orderBy.getOrderByClauses().iterator();

        while(i$.hasNext()) {
            OrderByClause clause = (OrderByClause)i$.next();
            int direction = "asc".equals(clause.getDirection()) ? 1 : -1;
            result.put(clause.getField(), direction);
        }

        return result;
    }

    public List<Object> select(Class myClass, SelectCriteriaExpression q, long offset, long limit) {
        return this.select(myClass, q, new OrderBy(), offset, limit);
    }

    public List<Object> select(Class myClass, SelectCriteriaExpression q) {
        return this.select(myClass, q, new OrderBy(), -1L, -1L);
    }

    public List<Object> select(Class myClass, long offset, long limit) {
        return this.select(myClass, new OrderBy(), offset, limit);
    }

    public List<Object> select(Class myClass) {
        return this.select(myClass, -1L, -1L);
    }

    public List<Object> select(Class myClass, OrderBy orderBy, long offset, long limit) {
        return this.select(myClass, new SelectCriteriaExpression(), orderBy, offset, limit);
    }

    public List<Object> select(Class myClass, SelectCriteriaExpression q, OrderBy orderBy) {
        return this.select(myClass, q, orderBy, -1L, -1L);
    }

    public List<Object> select(Class myClass, OrderBy orderBy) {
        return this.select(myClass, orderBy, -1L, -1L);
    }

    public long count(Class myClass, SelectCriteriaExpression q) {
        return !this.isFileDescription(myClass) ? this.getCollection(myClass).count(this.getQuery(q)) : (long)this.getFileCollection(myClass).getFileList(this.getFileQuery(q)).count();
    }

    public long count(Class myClass) {
        return !this.isFileDescription(myClass) ? this.getCollection(myClass).count() : (long)this.getFileCollection(myClass).getFileList().count();
    }

    public void delete(Object o) {
        this.clearCache();

        try {
            this.delete(o.getClass(), ((HHHIdentifiable)o).getHhhId());
        } catch (NoSuchObjectException var3) {
            throw new IllegalArgumentException(var3);
        }
    }

    public void delete(Class myClass, long hhhId) throws NoSuchObjectException {
        this.clearCache();
        BasicDBObject query = new BasicDBObject("_id", this.refConverter.toObjectId(myClass, hhhId));
        if (!this.isFileDescription(myClass)) {
            this.getCollection(myClass).remove(query);
        } else {
            this.getFileCollection(myClass).remove(query);
        }

    }

    public long delete(Class myClass, SelectCriteriaExpression q) {
        this.clearCache();
        if (!this.isFileDescription(myClass)) {
            return (long)this.getCollection(myClass).remove(this.getQuery(q)).getN();
        } else {
            DBObject query = this.getFileQuery(q);
            GridFS fileCollection = this.getFileCollection(myClass);
            int result = fileCollection.find(query).size();
            fileCollection.remove(query);
            return (long)result;
        }
    }

    public <P> P refresh(P o) {
        try {
            return this.retrieve(o.getClass(), ((HHHIdentifiable)o).getHhhId());
        } catch (NoSuchObjectException var3) {
            return o;
        }
    }

    private void clearCache() {
        this.cache.set(new HashMap());
    }
}
