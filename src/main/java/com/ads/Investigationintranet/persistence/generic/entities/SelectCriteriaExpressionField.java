package com.ads.Investigationintranet.persistence.generic.entities;

public class SelectCriteriaExpressionField {
    private String name;
    private String function;

    public SelectCriteriaExpressionField(String name) {
        this.name = name;
    }

    public SelectCriteriaExpressionField(String function, String name) {
        this.function = function;
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFunction() {
        return this.function;
    }

    public void setFunction(String function) {
        this.function = function;
    }

    public boolean hasFunction() {
        return this.function != null;
    }
}
