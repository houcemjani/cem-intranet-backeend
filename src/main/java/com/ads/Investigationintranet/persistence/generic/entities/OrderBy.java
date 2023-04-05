package com.ads.Investigationintranet.persistence.generic.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class OrderBy implements Serializable {
    private List<OrderByClause> orderByClauses = new ArrayList<>();

    public OrderBy() {
    }

    public OrderBy(OrderByClause orderByClause) {
        this.addOrderByClause(orderByClause);
    }

    public OrderBy(String field) {
        this.addOrderByClause(new OrderByClause(field));
    }

    public OrderBy(String field, String direction) {
        this.addOrderByClause(new OrderByClause(field, direction));
    }

    public List<OrderByClause> getOrderByClauses() {
        return this.orderByClauses;
    }

    public void setOrderByClauses(List<OrderByClause> orderByClauses) {
        this.orderByClauses = orderByClauses;
    }

    public void addOrderByClause(OrderByClause orderByClause) {
        this.orderByClauses.add(orderByClause);
    }

    public void addOrderByClause(String field) {
        this.addOrderByClause(new OrderByClause(field));
    }

    public void addOrderByClause(String field, String direction) {
        this.addOrderByClause(new OrderByClause(field, direction));
    }

    public OrderBy then(OrderByClause orderByClause) {
        this.addOrderByClause(orderByClause);
        return this;
    }

    public OrderBy then(String field) {
        this.addOrderByClause(new OrderByClause(field));
        return this;
    }

    public OrderBy then(String field, String direction) {
        this.addOrderByClause(new OrderByClause(field, direction));
        return this;
    }

    public boolean isComplete() {
        return this.orderByClauses.size() > 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderBy orderBy = (OrderBy) o;
        return Objects.equals(orderByClauses, orderBy.orderByClauses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderByClauses);
    }
}

