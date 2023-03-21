package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Embedded;
import javax.persistence.Entity;

@Entity

@DiscriminatorValue("TREATMENT")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TreatmentDesignLevel extends AbstractDesignLevel {

    @Embedded
    private TreatmentStudiedMolecule studiedMolecule;
    @Embedded
    private TreatmentAdministrationRoute administrationRoute;
    @Embedded
    private TreatmentDose dose;


}
