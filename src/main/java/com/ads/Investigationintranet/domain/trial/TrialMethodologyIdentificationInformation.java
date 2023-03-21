package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ig_trial_methodology_identification_information")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrialMethodologyIdentificationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long hhhId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "protocolHhhId")
    private TrialProtocol protocol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatmentExperimentalHhhId")
    private TreatmentExperimental treatmentExperimental;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_treatment")
    @OrderBy("hhhId ASC")
    private Set<TrialTreatment> trialTreatments = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_technique_type")
    private Set<TrialTechniqueType> trialTechniqueTypes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_therapeutics_class_for_drugs")
    private Set<TherapeuticClassForDrugs> therapeuticClassForDrugs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_therapeutic_subclasses_for_drugs")
    @OrderBy("hhhId ASC")
    private Set<TherapeuticSubClassForDrugs> therapeuticSubClassForDrugs = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_target_treatments_exp_pricipal")
    @OrderBy("hhhId ASC")
    private Set<TargetOfTreatmentExperimental> targetsOfTreatmentExperimentalPrincipal = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_treatment_exp_other")
    @OrderBy("hhhId ASC")
    private Set<TreatmentExperimental> othersTreatmentExperimental = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_target_treatment_exp")
    @OrderBy("hhhId ASC")
    private Set<TargetOfTreatmentExperimental> targetsOfTreatmentExperimental = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_studied_molecules")
    @OrderBy("hhhId ASC")
    private Set<TreatmentExperimental> moleculesStudiedList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_trial_administration_routes")
    @OrderBy("hhhId ASC")
    private Set<AdministrationRoute> administrationRoutes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_2_metastatic_lines")
    @OrderBy("hhhId ASC")
    private Set<MetastaticLine> metastaticLines = new HashSet<>();

    @Column
    private String frequencyOfTreatmentAdministration;

    @Column
    private String dmTrial;

    @Column
    private String minimalAge;

    @Column
    private String maximalAge;

    @Column
    private String moleculeStudied;

    @Column
    private String trialTechniqueTypeOtherValue;

    @Column
    private Integer technologicalMaturityLevel;

    @Column
    private String otherTreatmentMethodology;


}
