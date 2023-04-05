package com.ads.Investigationintranet.persistence.implementation.mongo;

import com.ads.Investigationintranet.persistence.generic.entities.OrderBy;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpression;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpressionField;
import com.ads.Investigationintranet.persistence.generic.entities.SelectResult;
import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;
import com.ads.Investigationintranet.persistence.generic.stereotypes.Configuration;
import com.ads.Investigationintranet.persistence.generic.stereotypes.DAO;
import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;
import com.ads.Investigationintranet.persistence.generic.stereotypes.Manager;
import com.ads.Investigationintranet.persistence.generic.stereotypes.RetrievedItemBeanContextInitialiser;
import com.ads.Investigationintranet.persistence.generic.stereotypes.RetrievedItemPostProcessor;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

public abstract class MongoDAO<P> implements DAO<P> {
    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private Configuration appConfiguration;
    MongoManager persistenceManager = null;
    private RetrievedItemPostProcessor<P> retrievedItemPostProcessor;
    private RetrievedItemBeanContextInitialiser<P> retrievedItemBeanContextInitialiser;

    public MongoDAO() {
    }

    public Manager getPersistenceManager() {
        if (this.persistenceManager == null) {
            this.setPersistenceManager();
        }

        return this.persistenceManager;
    }

    public void setPersistenceManager() {
        if (this.applicationContext.containsBean("mongoManagerForUnitTesting")) {
            this.persistenceManager = (MongoManager)this.applicationContext.getBean("mongoManagerForUnitTesting");
        } else if (this.appConfiguration.get("app.persistence.configuration.mongo.uri") != null) {
            this.persistenceManager = (MongoManager)this.applicationContext.getBean("mongoImplementationManager");
        } else {
            this.persistenceManager = (MongoManager)this.applicationContext.getBean("mongoDummyManager");
        }

    }

    public boolean isNew(HHHIdentifiable o) {
        return o.getHhhId() == 0L;
    }

    public P persist(P o) throws PersistException {
        P p = (P)this.persistenceManager.persist(o);
        return p;
    }

    public P retrieve(long hhhId) throws NoSuchObjectException {
        return this.retrieve(hhhId, false);
    }

    public P retrieve(long hhhId, boolean clearCache) throws NoSuchObjectException {
        P object = this.persistenceManager.retrieve(this.getMyClass(), hhhId, clearCache);
        if (this.retrievedItemBeanContextInitialiser != null) {
            this.retrievedItemBeanContextInitialiser.initialiseBeansContextOnRetrievedItem(object);
        }

        if (this.retrievedItemPostProcessor != null) {
            this.retrievedItemPostProcessor.postProcessRetrievedItem(object);
        }

        return object;
    }

    public void setRetrievedItemBeanContextInitialiser(RetrievedItemBeanContextInitialiser retrievedItemBeanContextInitialiser) {
        this.retrievedItemBeanContextInitialiser = retrievedItemBeanContextInitialiser;
    }

    public void setRetrievedItemPostProcessor(RetrievedItemPostProcessor retrievedItemPostProcessor) {
        this.retrievedItemPostProcessor = retrievedItemPostProcessor;
    }

    public SelectResult<P> select(SelectCriteriaExpression q, OrderBy orderBy, long offset, long limit) {
        SelectResult<P> selectResult = new SelectResult();
        List<Object> results = q.isComplete() ? this.persistenceManager.select(this.getMyClass(), q, orderBy, offset, limit) : this.persistenceManager.select(this.getMyClass(), orderBy, offset, limit);
        selectResult.setResults((List<P>)results);
        this.completeSelectResult(selectResult, offset, limit);
        Iterator i$;
        Object object;
        if (this.retrievedItemBeanContextInitialiser != null) {
            i$ = selectResult.getResults().iterator();

            while(i$.hasNext()) {
                object = i$.next();
                this.retrievedItemBeanContextInitialiser.initialiseBeansContextOnRetrievedItem((P)object);
            }
        }

        if (this.retrievedItemPostProcessor != null) {
            i$ = selectResult.getResults().iterator();

            while(i$.hasNext()) {
                object = i$.next();
                this.retrievedItemPostProcessor.postProcessRetrievedItem((P)object);
            }
        }

        return selectResult;
    }

    public SelectResult<P> selectWithCountTotal(SelectCriteriaExpression q, OrderBy orderBy, long offset, long limit) {
        SelectCriteriaExpression selectCriteriaExpressionCopy = null;

        try {
            selectCriteriaExpressionCopy = (SelectCriteriaExpression)q.clone();
        } catch (CloneNotSupportedException var10) {
            var10.printStackTrace();
        }

        SelectResult<P> selectResult = this.select(q, orderBy, offset, limit);
        Long count = this.count(selectCriteriaExpressionCopy);
        selectResult.setFoundTotal(count);
        return selectResult;
    }

    private void completeSelectResult(SelectResult<P> selectResult, long offset, long limit) {
        List<P> results = selectResult.getResults();
        selectResult.setFoundTotal((long)results.size());
        selectResult.setFetchedFrom(offset >= 0L ? offset : 0L);
        selectResult.setFetchedTo(results.size() - 1 >= 0 ? selectResult.getFetchedFrom() + (long)results.size() - 1L : 0L);
    }

    public SelectResult<P> select(String field, String operator, Object value) {
        return this.select(new SelectCriteriaExpression(field, operator, value));
    }

    public SelectResult<P> select(String field, Object value) {
        return this.select(new SelectCriteriaExpression(field, value));
    }

    public SelectResult<P> select(String field, Object value, long offset, long limit) {
        return this.select(new SelectCriteriaExpression(field, value), offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(String field, Object value, long offset, long limit) {
        return this.selectWithCountTotal(new SelectCriteriaExpression(field, value), new OrderBy(), offset, limit);
    }

    public SelectResult<P> select(SelectCriteriaExpressionField field, String operator, Object value) {
        return this.select(new SelectCriteriaExpression(field, operator, value));
    }

    public SelectResult<P> select(SelectCriteriaExpression q, long offset, long limit) {
        return this.select(q, new OrderBy(), offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(SelectCriteriaExpression q, long offset, long limit) {
        return this.selectWithCountTotal(q, new OrderBy(), offset, limit);
    }

    public SelectResult<P> select(long offset, long limit) {
        return this.select(new SelectCriteriaExpression(), offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(long offset, long limit) {
        return this.selectWithCountTotal(new SelectCriteriaExpression(), new OrderBy(), offset, limit);
    }

    public SelectResult<P> select(SelectCriteriaExpression q) {
        return this.select(q, -1L, -1L);
    }

    public SelectResult<P> select() {
        return this.select(new SelectCriteriaExpression());
    }

    public SelectResult<P> select(String field, String operator, Object value, OrderBy orderBy) {
        return this.select(field, operator, value, orderBy, -1L, -1L);
    }

    public SelectResult<P> select(SelectCriteriaExpressionField field, String operator, Object value, OrderBy orderBy) {
        return this.select(field, operator, value, orderBy, -1L, -1L);
    }

    public SelectResult<P> select(String field, Object value, OrderBy orderBy) {
        return this.select(field, value, orderBy, -1L, -1L);
    }

    public SelectResult<P> select(String field, String operator, Object value, OrderBy orderBy, long offset, long limit) {
        return this.select(new SelectCriteriaExpression(field, operator, value), orderBy, offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(String field, String operator, Object value, OrderBy orderBy, long offset, long limit) {
        return this.selectWithCountTotal(new SelectCriteriaExpression(field, operator, value), orderBy, offset, limit);
    }

    public SelectResult<P> select(SelectCriteriaExpressionField field, String operator, Object value, OrderBy orderBy, long offset, long limit) {
        return this.select(new SelectCriteriaExpression(field, operator, value), orderBy, offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(SelectCriteriaExpressionField field, String operator, Object value, OrderBy orderBy, long offset, long limit) {
        return this.selectWithCountTotal(new SelectCriteriaExpression(field, operator, value), orderBy, offset, limit);
    }

    public SelectResult<P> select(String field, Object value, OrderBy orderBy, long offset, long limit) {
        return this.select(new SelectCriteriaExpression(field, value), orderBy, offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(String field, Object value, OrderBy orderBy, long offset, long limit) {
        return this.selectWithCountTotal(new SelectCriteriaExpression(field, value), new OrderBy(), offset, limit);
    }

    public SelectResult<P> select(OrderBy orderBy, long offset, long limit) {
        return this.select(new SelectCriteriaExpression(), orderBy, offset, limit);
    }

    public SelectResult<P> selectWithCountTotal(OrderBy orderBy, long offset, long limit) {
        return this.selectWithCountTotal(new SelectCriteriaExpression(), orderBy, offset, limit);
    }

    public SelectResult<P> select(SelectCriteriaExpression q, OrderBy orderBy) {
        return this.select(q, orderBy, -1L, -1L);
    }

    public SelectResult<P> select(OrderBy orderBy) {
        return this.select(new SelectCriteriaExpression(), orderBy, -1L, -1L);
    }

    public long count(SelectCriteriaExpression q) {
        return this.persistenceManager.count(this.getMyClass(), q);
    }

    public long count() {
        return this.persistenceManager.count(this.getMyClass());
    }

    public void delete(Object o) {
        this.persistenceManager.delete(o);
    }

    public void delete(long hhhId) throws NoSuchObjectException {
        this.persistenceManager.delete(this.getMyClass(), hhhId);
    }

    public long delete(SelectCriteriaExpression q) {
        return this.persistenceManager.delete(this.getMyClass(), q);
    }

    public P refresh(P o) {
        return this.persistenceManager.refresh(o);
    }

    public void detach(Object o) {
    }

    protected abstract Class<P> getMyClass();
}
