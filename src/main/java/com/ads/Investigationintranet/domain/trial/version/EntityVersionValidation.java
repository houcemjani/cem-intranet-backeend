

package com.ads.Investigationintranet.domain.trial.version;

import java.util.List;

public class EntityVersionValidation {
    private String userName;
    private String date;
    private VersionType versionType;
    private String reference;
    private long hhhId;
    private String entityName;
    private Boolean active;
    private List<FieldVersionValidation> fieldVersionValidation;

    public EntityVersionValidation() {
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public VersionType getVersionType() {
        return versionType;
    }

    public void setVersionType(VersionType versionType) {
        this.versionType = versionType;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public long getHhhId() {
        return hhhId;
    }

    public void setHhhId(long hhhId) {
        this.hhhId = hhhId;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public List<FieldVersionValidation> getFieldVersionValidation() {
        return fieldVersionValidation;
    }

    public void setFieldVersionValidation(List<FieldVersionValidation> fieldVersionValidation) {
        this.fieldVersionValidation = fieldVersionValidation;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
