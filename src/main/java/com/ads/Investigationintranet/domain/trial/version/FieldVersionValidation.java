

package com.ads.Investigationintranet.domain.trial.version;

/**
 * Created by mokni on 17/04/2017.
 */
public class FieldVersionValidation {
    private String versionValue;
    private String value;
    private boolean valid;
    private String field;

    public FieldVersionValidation() {
    }

    public String getVersionValue() {
        return versionValue;
    }

    public void setVersionValue(String versionValue) {
        this.versionValue = versionValue;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }
}
