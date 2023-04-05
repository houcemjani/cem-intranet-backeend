package com.ads.Investigationintranet.persistence.generic.stereotypes;

import com.ads.Investigationintranet.persistence.generic.entities.OrderBy;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpression;
import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;

import java.util.List;

public interface Manager {
    Object persist(Object var1) throws PersistException;

    List<Object> persistList(List<Object> var1) throws PersistException;

    <P> P retrieve(Class var1, long var2) throws NoSuchObjectException;

    <P> P retrieve(Class var1, long var2, boolean var4) throws NoSuchObjectException;

    List<Object> select(Class var1, SelectCriteriaExpression var2, long var3, long var5);

    List<Object> select(Class var1, SelectCriteriaExpression var2);

    List<Object> select(Class var1, long var2, long var4);

    List<Object> select(Class var1);

    List<Object> select(Class var1, SelectCriteriaExpression var2, OrderBy var3, long var4, long var6);

    List<Object> select(Class var1, SelectCriteriaExpression var2, OrderBy var3);

    List<Object> select(Class var1, OrderBy var2, long var3, long var5);

    List<Object> select(Class var1, OrderBy var2);

    long count(Class var1, SelectCriteriaExpression var2);

    long count(Class var1);

    void delete(Object var1);

    long delete(Class var1, SelectCriteriaExpression var2);

    void delete(Class var1, long var2) throws NoSuchObjectException;
}
