package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Getter
@Setter
@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class TreatmentStudiedMolecule {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "studied_molecule_id")
    
    private MoleculeStudied studiedMolecule;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_expreimental_id")
    
    private TreatmentExperimental treatmentExperimental;

    private Boolean studiedMoleculeEnabled;


}
