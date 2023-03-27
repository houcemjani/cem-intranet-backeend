package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
import com.ads.Investigationintranet.entity.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "ig_trial_incl_excl_criteria",
        uniqueConstraints = @UniqueConstraint(columnNames = {"protocol_id", "trial_id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialInclusionExclusionCriteria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    private Boolean biopsiesRequired;
    private String numberOfPreviousTreatmentLines;
    private String inclusionCriteria;
    private String otherSpecificCriteria;
    private String otherSpecificCriteriaSingle;
    private String inclusionExclusionComments;
    private String inclusionCriteriaComment;
    private String preTreatmentNotAuthorized;
    private Boolean hasMolecularPreScreening;
    private Boolean hasBiomarker;
    private String sex;


    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trial_id", updatable = false)
    private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "protocol_id")
    private TrialProtocol protocol;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_biopsies")
    private Set<Biopsies> biopsies = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_ecogs")
    private Set<OmsEcog> omsEcogs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_organs")
    private Set<Organ> organs = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_organs_families")
    private Set<OrganFamily> organFamilies = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "inc_exc_criteria_histologies")
    private Set<InclusionHistologies> inclusionHistologies = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_biomarkers")
    private Set<InclusionBiomarkers> inclusionBiomarkers = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_exclusion_criterias")
    private Set<ExclusionCriteria> exclusionCriteria = new HashSet<>();
    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_illness_states")
    private Set<IllnessState> illnessStates = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_metastatic_lines")
    private Set<MetastaticLine> metastaticLines = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "inclusion_exclusion_criteria_molecular_anomaly_types")
    private Set<MolecularAnomalyType> molecularAnomalyTypes = new HashSet<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_pre_screening_molecule")
    private Set<InclusionBiomarkers> inclusionPreScreeningMolecules = new HashSet<>();

    private Boolean hasProvider;

    private String providerName;

    @ManyToOne(fetch = FetchType.LAZY)
    private EstablishmentDepartment establishmentDepartment;

    @Column
    private String illnessClassification;

    @Column
    private String interventionalProtocol;

    @ManyToOne(fetch = FetchType.LAZY)
    private ResearchType researchType;

    @Column
    private String researchTypeOtherValue;

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_trial_type")
    private Set<TrialType> trialTypes = new HashSet<>();

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_research_object")
    private List<ResearchField> researchObjects = new ArrayList<>();

    @Column
    private String researchFieldOtherValue;

    @ManyToOne(fetch = FetchType.LAZY)
    private ResearchNature researchNature;

    @Column
    private String researchNatureOtherValue;

    @ManyToMany
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "incl_excl_intervention_type")
    private Set<InterventionType> interventionTypes = new HashSet<>();

    @Column
    private String dmTrial;

}
