package com.ads.Investigationintranet.domain.trial.version;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class AdditionalCostId implements Serializable {

    @Column
    private Long additionalCostHhhId ;

    @Column
    private String additionalCostType;

    public AdditionalCostId() {
    }

    public AdditionalCostId(Long additionalCostHhhId, String additionalCostType) {
        this.additionalCostHhhId = additionalCostHhhId;
        this.additionalCostType = additionalCostType;
    }

    public AdditionalCostId(Long trialActHhhId) {
    this.additionalCostHhhId = trialActHhhId;
    }

    public Long getAdditionalCostHhhId() {
        return additionalCostHhhId;
    }

    public void setAdditionalCostHhhId(Long additionalCostHhhId) {
        this.additionalCostHhhId = additionalCostHhhId;
    }

    public String getAdditionalCostType() {
        return additionalCostType;
    }

    public void setAdditionalCostType(String additionalCostType) {
        this.additionalCostType = additionalCostType;
    }
}
