package com.ads.Investigationintranet.persistence.generic.service;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;
import com.ads.Investigationintranet.persistence.generic.stereotypes.DAO;
import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;
import com.ads.Investigationintranet.persistence.generic.stereotypes.RetrievedItemBeanContextInitialiser;
import com.ads.Investigationintranet.persistence.generic.stereotypes.RetrievedItemPostProcessor;
import org.joda.time.LocalDate;

public abstract class GenericService<P> implements Service<P>, RetrievedItemBeanContextInitialiser<P> {
    private static Pattern patternFieldName = Pattern.compile("^(.)(.*)$");

    public GenericService() {
    }

    protected DAO<P> initDAO(DAO<P> dao) {
        dao.setRetrievedItemBeanContextInitialiser(this);
        return dao;
    }

    protected DAO<P> initDAO(DAO<P> dao, RetrievedItemPostProcessor retrievedItemPostProcessor) {
        dao.setRetrievedItemPostProcessor(retrievedItemPostProcessor);
        return this.initDAO(dao);
    }

    public List<P> persistList(List<P> objects) throws PersistException {
        return this.getDAO().persistList(objects);
    }

    public void initialiseBeansContextOnRetrievedItem(P p) {
    }

    public P retrieve(long hhhId) throws NoSuchObjectException {
        return (P)this.getDAO().retrieve(hhhId);
    }

    public P persist(P o) throws PersistException {
        return (P)this.getDAO().persist(o);
    }

    public P persistFields(P newObject, String... fields) throws PersistException {
        P originalObject = null;
        if (((HHHIdentifiable)newObject).getHhhId() <= 0L) {
            return this.persist(newObject);
        } else {
            Map<String, Field> authorisedFields = new HashMap();

            int len$;
            int i$;
            for(Class currentClassForAuthorisedFields = newObject.getClass(); !currentClassForAuthorisedFields.getName().equals("java.lang.Object"); currentClassForAuthorisedFields = currentClassForAuthorisedFields.getSuperclass()) {
                Field[] arr$ = currentClassForAuthorisedFields.getDeclaredFields();
                len$ = arr$.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    Field field = arr$[i$];
                    authorisedFields.put(field.getName(), field);
                }
            }

            try {
                this.getDAO().detach(newObject);
                originalObject = (P)this.getDAO().retrieve(((HHHIdentifiable)newObject).getHhhId());
                String[] arr$ = fields;
                len$ = fields.length;

                for(i$ = 0; i$ < len$; ++i$) {
                    String field = arr$[i$];
                    String fieldUCF = null;
                    String getter = null;
                    String setter = null;
                    Method methodGetter = null;
                    Method methodSetter = null;
                    Matcher matcherFieldName = patternFieldName.matcher(field);
                    if (!matcherFieldName.matches()) {
                        return null;
                    }

                    fieldUCF = matcherFieldName.group(1).toUpperCase() + matcherFieldName.group(2);
                    setter = "set" + fieldUCF;
                    if (((Field)authorisedFields.get(field)).getType().getName().equals("boolean")) {
                        getter = "is" + fieldUCF;
                    } else {
                        getter = "get" + fieldUCF;
                    }

                    methodGetter = newObject.getClass().getMethod(getter);
                    Class fieldType = ((Field)authorisedFields.get(field)).getType();
                    if (fieldType.getName().equals("java.util.Calendar")) {
                        fieldType = LocalDate.class;
                    } else if (fieldType.getName().equals("java.math.BigDecimal")) {
                        fieldType = Double.TYPE;
                    }

                    methodSetter = newObject.getClass().getMethod(setter, fieldType);
                    Object newValue = methodGetter.invoke(newObject);
                    methodSetter.invoke(originalObject, newValue);
                }
            } catch (NoSuchMethodException var18) {
                var18.printStackTrace();
                return null;
            } catch (NoSuchObjectException var19) {
                var19.printStackTrace();
                return null;
            } catch (InvocationTargetException var20) {
                var20.printStackTrace();
                return null;
            } catch (IllegalAccessException var21) {
                var21.printStackTrace();
                return null;
            }

            return this.persist(originalObject);
        }
    }

    public boolean isNew(HHHIdentifiable o) {
        return this.getDAO().isNew(o);
    }

    public IsDeletable isDeletable(P p) {
        return new IsDeletable();
    }

    public IsDeletable isDeletable(long hhhId) {
        try {
            return this.isDeletable((P)this.getDAO().retrieve(hhhId));
        } catch (NoSuchObjectException var4) {
            return new IsDeletable(false, "INVALID_ENTITY");
        }
    }

    public void delete(P o) {
        this.getDAO().delete(o);
    }
}

