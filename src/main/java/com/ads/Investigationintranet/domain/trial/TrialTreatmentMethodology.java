package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ig_trial_treatment_methodology")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrialTreatmentMethodology {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    private String frequencyOfTreatmentAdministration;
    private String dmTrial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trial_id", updatable = false)
    private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_id")
    private TrialProtocol protocol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "treatment_experimental_id")
    private TreatmentExperimental treatmentExperimental;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_trial_treatment")
    private Set<TrialTreatment> trialTreatments = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_trial_technique_type")
    private Set<TrialTechniqueType> trialTechniqueTypes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_therapudics_class")
    private Set<TherapeuticClassForDrugs> therapeuticClassForDrugs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_therapudic_subclasses")
    private Set<TherapeuticSubClassForDrugs> therapeuticSubClassForDrugs = new HashSet<>();


    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_target_treatments")
    private Set<TargetOfTreatmentExperimental> targetsOfTreatmentExperimentalPrincipal = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_experimental_treatment")
    private Set<TreatmentExperimental> othersTreatmentExperimental = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_target_exp_treatment")
    private Set<TargetOfTreatmentExperimental> targetsOfTreatmentExperimental = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_studied_molecules")
    private Set<TreatmentExperimental> moleculesStudiedList = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_admin_routes")
    private Set<AdministrationRoute> administrationRoutes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_methodology_metastatic_lines")
    private Set<MetastaticLine> metastaticLines = new HashSet<>();

    @Column
    private String trialTechniqueTypeOtherValue;

    @Column
    private String pharmaceuticalCircuitLatestVersion;

    @Column
    private Boolean inIndicationAMM;

    @Column
    private Boolean outOfIndicationAMM;

    @Column
    private Boolean withoutAMM;

    @Column
    private Boolean franceAMM;

    @Column
    private Boolean otherCountriesAMM;

    @Column
    private Boolean medicoEconomic;

    @Column
    private Boolean cancerTrial;

    @Column
    private Boolean interventionResearch;

}
