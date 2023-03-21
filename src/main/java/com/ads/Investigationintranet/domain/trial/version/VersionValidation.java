

package com.ads.Investigationintranet.domain.trial.version;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mokni on 14/04/2017.
 */
public class VersionValidation {
    private String entityClassName;
    private boolean valid;
    private Integer entitiesNumber;
    private Integer fieldsNumber;
    private List<String> changedFields = new ArrayList<>();
    private List<Long> idsNotValid=new ArrayList<>();
    private List<Long> idsWithoutVersion=new ArrayList<>();

    public VersionValidation() {
    }

    public String getEntityClassName() {
        return entityClassName;
    }

    public void setEntityClassName(String entityClassName) {
        this.entityClassName = entityClassName;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public List<String> getChangedFields() {
        return changedFields;
    }

    public void setChangedFields(List<String> changedFields) {
        this.changedFields = changedFields;
    }

    public List<Long> getIdsNotValid() {
        return idsNotValid;
    }

    public void setIdsNotValid(List<Long> idsNotValid) {
        this.idsNotValid = idsNotValid;
    }

    public List<Long> getIdsWithoutVersion() {
        return idsWithoutVersion;
    }

    public void setIdsWithoutVersion(List<Long> idswithoutVersion) {
        this.idsWithoutVersion = idswithoutVersion;
    }

    public Integer getEntitiesNumber() {
        return entitiesNumber;
    }

    public void setEntitiesNumber(Integer entitiesNumber) {
        this.entitiesNumber = entitiesNumber;
    }

    public Integer getFieldsNumber() {
        return fieldsNumber;
    }

    public void setFieldsNumber(Integer fieldsNumber) {
        this.fieldsNumber = fieldsNumber;
    }
}
