package com.ads.Investigationintranet.persistence.generic.entities;

import java.io.Serializable;
import java.util.Objects;

public class OrderByClause implements Serializable {
    String field;
    String direction;

    public OrderByClause() {
    }

    public OrderByClause(String field) {
        this.field = field;
    }

    public OrderByClause(String field, String direction) {
        this.field = field;
        this.direction = direction;
    }

    public String getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public String getDirection() {
        return this.direction == null ? "asc" : this.direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderByClause that = (OrderByClause) o;
        return Objects.equals(field, that.field) &&
                Objects.equals(direction, that.direction);
    }

    @Override
    public int hashCode() {
        return Objects.hash(field, direction);
    }
}

