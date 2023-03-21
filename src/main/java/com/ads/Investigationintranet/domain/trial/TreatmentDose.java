package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Nationalized;

import javax.persistence.Embeddable;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentDose {
    @Nationalized
    private String dose;
    private Boolean doseEnabled;

    public TreatmentDose(Boolean doseEnabled) {
        this.doseEnabled = doseEnabled;
    }
}
