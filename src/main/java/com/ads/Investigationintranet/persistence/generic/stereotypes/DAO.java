package com.ads.Investigationintranet.persistence.generic.stereotypes;

import com.ads.Investigationintranet.persistence.generic.entities.OrderBy;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpression;
import com.ads.Investigationintranet.persistence.generic.entities.SelectCriteriaExpressionField;
import com.ads.Investigationintranet.persistence.generic.entities.SelectResult;
import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;

import java.util.List;

public interface DAO<P> {
    boolean isNew(HHHIdentifiable var1);
    P persist(P var1) throws PersistException;
    List<P> persistList(List<P> var1) throws PersistException;
    P retrieve(long var1) throws NoSuchObjectException;
    P retrieve(long var1, boolean var3) throws NoSuchObjectException;
    Manager getPersistenceManager();
    void setRetrievedItemPostProcessor(RetrievedItemPostProcessor var1);
    void setRetrievedItemBeanContextInitialiser(RetrievedItemBeanContextInitialiser var1);
    SelectResult<P> select(String var1, String var2, Object var3);
    SelectResult<P> select(SelectCriteriaExpressionField var1, String var2, Object var3);
    SelectResult<P> select(String var1, Object var2);
    SelectResult<P> select(String var1, Object var2, long var3, long var5);
    SelectResult<P> selectWithCountTotal(String var1, Object var2, long var3, long var5);
    SelectResult<P> select(long var1, long var3);
    SelectResult<P> selectWithCountTotal(long var1, long var3);
    SelectResult<P> select(SelectCriteriaExpression var1, long var2, long var4);
    SelectResult<P> selectWithCountTotal(SelectCriteriaExpression var1, long var2, long var4);
    SelectResult<P> select(SelectCriteriaExpression var1);
    SelectResult<P> select();
    SelectResult<P> select(String var1, String var2, Object var3, OrderBy var4);
    SelectResult<P> select(SelectCriteriaExpressionField var1, String var2, Object var3, OrderBy var4);
    SelectResult<P> select(String var1, Object var2, OrderBy var3);
    SelectResult<P> select(String var1, String var2, Object var3, OrderBy var4, long var5, long var7);
    SelectResult<P> selectWithCountTotal(String var1, String var2, Object var3, OrderBy var4, long var5, long var7);
    SelectResult<P> select(SelectCriteriaExpressionField var1, String var2, Object var3, OrderBy var4, long var5, long var7);
    SelectResult<P> selectWithCountTotal(SelectCriteriaExpressionField var1, String var2, Object var3, OrderBy var4, long var5, long var7);
    SelectResult<P> select(String var1, Object var2, OrderBy var3, long var4, long var6);
    SelectResult<P> selectWithCountTotal(String var1, Object var2, OrderBy var3, long var4, long var6);
    SelectResult<P> select(OrderBy var1, long var2, long var4);
    SelectResult<P> selectWithCountTotal(OrderBy var1, long var2, long var4);
    SelectResult<P> select(SelectCriteriaExpression var1, OrderBy var2, long var3, long var5);
    SelectResult<P> selectWithCountTotal(SelectCriteriaExpression var1, OrderBy var2, long var3, long var5);
    SelectResult<P> select(SelectCriteriaExpression var1, OrderBy var2);
    SelectResult<P> select(OrderBy var1);
    long count(SelectCriteriaExpression var1);
    long count();
    void delete(Object var1);
    long delete(SelectCriteriaExpression var1);
    void delete(long var1) throws NoSuchObjectException;
    P refresh(P var1);
    void detach(Object var1);
}

