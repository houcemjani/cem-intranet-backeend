package com.ads.Investigationintranet.persistence.implementation.mongo;

import com.ads.Investigationintranet.persistence.generic.entities.OrderBy;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpression;
import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;
import com.mongodb.BasicDBList;
import java.util.List;

public class MongoDummyManager implements MongoManager {
    public MongoDummyManager() {
    }

    public <P> List<P> resolveReferences(BasicDBList list, Class<P> myClass) {
        return null;
    }

    public <P> P refresh(P o) {
        return null;
    }

    public Object persist(Object o) throws PersistException {
        return null;
    }

    public List<Object> persistList(List<Object> objects) throws PersistException {
        return null;
    }

    public <P> P retrieve(Class aClass, long l) throws NoSuchObjectException {
        return null;
    }

    public <P> P retrieve(Class aClass, long l, boolean b) throws NoSuchObjectException {
        return null;
    }

    public List<Object> select(Class aClass, SelectCriteriaExpression selectCriteriaExpression, long l, long l1) {
        return null;
    }

    public List<Object> select(Class aClass, SelectCriteriaExpression selectCriteriaExpression) {
        return null;
    }

    public List<Object> select(Class aClass, long l, long l1) {
        return null;
    }

    public List<Object> select(Class aClass) {
        return null;
    }

    public List<Object> select(Class aClass, SelectCriteriaExpression selectCriteriaExpression, OrderBy orderBy, long l, long l1) {
        return null;
    }

    public List<Object> select(Class aClass, SelectCriteriaExpression selectCriteriaExpression, OrderBy orderBy) {
        return null;
    }

    public List<Object> select(Class aClass, OrderBy orderBy, long l, long l1) {
        return null;
    }

    public List<Object> select(Class aClass, OrderBy orderBy) {
        return null;
    }

    public long count(Class aClass, SelectCriteriaExpression selectCriteriaExpression) {
        return 0L;
    }

    public long count(Class aClass) {
        return 0L;
    }

    public void delete(Object o) {
    }

    public long delete(Class aClass, SelectCriteriaExpression selectCriteriaExpression) {
        return 0L;
    }

    public void delete(Class aClass, long l) throws NoSuchObjectException {
    }
}

