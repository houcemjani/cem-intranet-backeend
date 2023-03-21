

package com.ads.Investigationintranet.domain.report.inclusionstotalbymonth;

public class TrialInclusionsCell {
    private Long number;
    private Double inclusionsRatio;
    private TrialStatus trialStatus;

    public TrialInclusionsCell() {
    }

    public TrialInclusionsCell(Long number, Double inclusionsRatio) {
        this.number = number;
        this.inclusionsRatio = inclusionsRatio;
    }

    public TrialInclusionsCell(Long number, Double inclusionsRatio, TrialStatus trialStatus) {
        this.number = number;
        this.inclusionsRatio = inclusionsRatio;
        this.trialStatus = trialStatus;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public Double getInclusionsRatio() {
        return inclusionsRatio;
    }

    public void setInclusionsRatio(Double inclusionsRatio) {
        this.inclusionsRatio = inclusionsRatio;
    }

    public TrialStatus getTrialStatus() {
        return trialStatus;
    }

    public void setTrialStatus(TrialStatus trialStatus) {
        this.trialStatus = trialStatus;
    }
}
