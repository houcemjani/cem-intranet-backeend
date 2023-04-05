package com.ads.Investigationintranet.persistence.generic.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SelectCriteriaExpression implements Cloneable {
    private String type;
    private String whichValueTypeIsUsed;
    private SelectCriteriaExpressionField field;
    private String operator;
    private Object value;
    private List<SelectCriteriaExpression> selectCriteriaExpressions;
    private static Pattern patternClassName = Pattern.compile("([^\\.]+)$");

    public SelectCriteriaExpression() {
        this.selectCriteriaExpressions = new ArrayList();
    }

    public SelectCriteriaExpression(String field, Object value) {
        this(field, "equal", value);
    }

    public SelectCriteriaExpression(String field, String operator, Object value) {
        this(new SelectCriteriaExpressionField(field), operator, value);
    }

    public SelectCriteriaExpression(SelectCriteriaExpressionField field, String operator, Object value) {
        this.selectCriteriaExpressions = new ArrayList();
        this.type = "expression";
        this.field = field;
        this.operator = this.resolveOperator(operator, value);
        this.value = value;
        Matcher matcherClassName = patternClassName.matcher(value.getClass().getName());
        matcherClassName.find();
        this.whichValueTypeIsUsed = matcherClassName.group(1);
    }

    public SelectCriteriaExpression(String operator, SelectCriteriaExpression expression1, SelectCriteriaExpression expression2) {
        this.selectCriteriaExpressions = new ArrayList();
        this.type = "expressions";
        this.operator = operator;
        this.selectCriteriaExpressions.add(expression1);
        this.selectCriteriaExpressions.add(expression2);
    }

    public boolean isComplete() {
        return this.type != null;
    }

    public SelectCriteriaExpression and(SelectCriteriaExpression selectCriteriaExpression) {
        return this.isComplete() ? new SelectCriteriaExpression("and", this, selectCriteriaExpression) : selectCriteriaExpression;
    }

    public SelectCriteriaExpression and(SelectCriteriaExpressionField field, String operator, Object value) {
        return this.and(new SelectCriteriaExpression(field, operator, value));
    }

    public SelectCriteriaExpression and(String field, String operator, Object value) {
        return this.and(new SelectCriteriaExpression(field, operator, value));
    }

    public SelectCriteriaExpression and(String field, Object value) {
        return this.and(new SelectCriteriaExpression(field, value));
    }

    public SelectCriteriaExpression or(SelectCriteriaExpression selectCriteriaExpression) {
        return this.isComplete() ? new SelectCriteriaExpression("or", this, selectCriteriaExpression) : selectCriteriaExpression;
    }

    public SelectCriteriaExpression or(SelectCriteriaExpressionField field, String operator, Object value) {
        return this.or(new SelectCriteriaExpression(field, operator, value));
    }

    public SelectCriteriaExpression or(String field, String operator, Object value) {
        return this.or(new SelectCriteriaExpression(field, operator, value));
    }

    public SelectCriteriaExpression or(String field, Object value) {
        return this.or(new SelectCriteriaExpression(field, value));
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public SelectCriteriaExpressionField getField() {
        return this.field;
    }

    public void setField(String field) {
        this.field = new SelectCriteriaExpressionField(field);
    }

    public void setField(SelectCriteriaExpressionField field) {
        this.field = field;
    }

    public String getOperator() {
        return this.operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public Object getValue() {
        return this.value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public String getWhichValueTypeIsUsed() {
        return this.whichValueTypeIsUsed;
    }

    public void setWhichValueTypeIsUsed(String whichValueTypeIsUsed) {
        this.whichValueTypeIsUsed = whichValueTypeIsUsed;
    }

    public List<SelectCriteriaExpression> getSelectCriteriaExpressions() {
        return this.selectCriteriaExpressions;
    }

    public void setSelectCriteriaExpressions(List<SelectCriteriaExpression> selectCriteriaExpressions) {
        this.selectCriteriaExpressions = selectCriteriaExpressions;
    }

    private String resolveOperator(String operator, Object value) {
        boolean isValueNumeric = false;
        String valueClass = value.getClass().getName();
        if (valueClass.equals("java.lang.Short") || valueClass.equals("java.lang.Integer") || valueClass.equals("java.lang.Long") || valueClass.equals("java.lang.Double") || valueClass.equals("java.lang.Float")) {
            isValueNumeric = true;
        }

        if (operator.equals("=")) {
            return "equal";
        } else if (operator.equals(">")) {
            return isValueNumeric ? "gt" : "greaterThan";
        } else if (operator.equals(">=")) {
            return isValueNumeric ? "ge" : "greaterThanOrEqualTo";
        } else if (operator.equals("<")) {
            return isValueNumeric ? "lt" : "lessThan";
        } else if (operator.equals("<=")) {
            return isValueNumeric ? "le" : "lessThanOrEqualTo";
        } else {
            return operator;
        }
    }

    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
