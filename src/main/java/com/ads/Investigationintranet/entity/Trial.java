

package com.ads.Investigationintranet.entity;


import com.ads.Investigationintranet.domain.Cohort;
import com.ads.Investigationintranet.domain.Inclusion;
import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.domain.inclusion.InclusionArm;
import com.ads.Investigationintranet.domain.mobile.FileEntity;
import com.ads.Investigationintranet.domain.mobile.TrialMessage;
import com.ads.Investigationintranet.domain.trial.*;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.*;




@Entity
@Table(name = "ig_trials")


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Trial  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Transient
    private Collection<TrialContactableMemberLiaison> trialContactableMemberLiaisons = new ArrayList<>();

    @OneToMany(mappedBy = "trial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    private Collection<TrialSiteLiaison> trialSiteLiaisons = new ArrayList<>();

    @OneToMany(mappedBy = "trial", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<TrialPhaseLiaison> trialPhaseLiaisons = new ArrayList<>();

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TrialHumanResource trialHumanResource;

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TrialDisciplineIdentification trialDisciplineIdentification;

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TrialAdministrativeRegulatoryInformation trialAdministrativeRegulatoryInformation;

    @Column(name = "trialTypeOtherValue")
    @JsonProperty
    private String trialTypeOtherValue;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trials_2_research_field")
    
    @OrderBy("hhhId ASC")
    private List<ResearchField> researchFields;

    @Column(name = "randomised")
    @JsonProperty
    private boolean randomised;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trials_2_target_of_molecules",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "targetOfMoleculesHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<TargetOfMolecules> targetsOfMolecules = new ArrayList<>();

    @ManyToMany()
    
    private Collection<Biopsies> biopsies = new ArrayList<>();

    @ManyToMany
    
    private Collection<ExclusionCriteria> exclusionCriteria = new ArrayList<>();

    @ManyToMany
    
    private Collection<InclusionBiomarkers> inclusionBiomarkers = new ArrayList<>();

    @ManyToMany
    
    private Collection<InclusionHistologies> inclusionHistologies = new ArrayList<>();

    @ManyToMany
    
    private Collection<InclusionIndications> inclusionIndications = new ArrayList<>();

    @ManyToMany
    
    private Collection<OmsEcog> omsEcogs = new ArrayList<>();

    @Column(name = "numberOfPreviousTreatmentLines")
    @JsonProperty
    private String numberOfPreviousTreatmentLines;

    @Column(name = "biopsiesRequired")
    @JsonProperty
    private Boolean biopsiesRequired;

    @Column(name = "otherSpecificCriteria", columnDefinition = "text")
    @JsonProperty
    private String otherSpecificCriteria;

    @Column(name = "inclusionCriteria")
    @JsonProperty
    private String inclusionCriteria;

    @Column(name = "preThreatmentNotAuthorized", columnDefinition = "text")
    @JsonProperty
    private String preThreatmentNotAuthorized;

    @Column(name = "otherSpecificCriteriaSingle", columnDefinition = "MEDIUMBLOB")
    @JsonProperty
    private String otherSpecificCriteriaSingle;

    @Column(name = "inclusionExclusionComments")
    @JsonProperty
    private String inclusionExclusionComments;

    @Column(name = "inclusionCriteriaComment", columnDefinition = "VARCHAR(7300)")
    @JsonProperty
    private String inclusionCriteriaComment;

    @Column(name = "numberOfCentresOtherValue")
    @JsonProperty
    private String numberOfCentresOtherValue;

    @JsonIgnore
    @OneToMany(mappedBy = "trial", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    private Collection<OtherAmendmentAgreement> otherAmendmentAgreements = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "natureHhhId")
    
    @JsonProperty
    private Nature nature;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ghdcss")
    
    @JsonProperty
    private Ghdcss ghdcss;

    @Column(name = "substantialModification")
    @JsonProperty
    private Boolean substantialModification = false;


    @Column(name = "numberMS", columnDefinition = "text")
    @JsonProperty
    private String numberMS;

    @Column(name = "reasonMS", columnDefinition = "text")
    @JsonProperty
    private String reasonMS;

    @Column(name = "researchDuration", columnDefinition = "text")
    @JsonProperty
    private String researchDuration;

    @Column(name = "inclusionPeriod", columnDefinition = "text")
    @JsonProperty
    private String inclusionPeriod;

    @Column(name = "inclusionFollowup", columnDefinition = "text")
    @JsonProperty
    private String inclusionFollowup;

    @Temporal(TemporalType.DATE)
    @Column(name = "initialEvaluationCppSessionDate")
    @JsonProperty
    private Calendar initialEvaluationCppSessionDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "cppFavorableOpinionMSDate")
    @JsonProperty
    private Calendar cppFavorableOpinionMSDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "cppAuthorizationMSDate")
    @JsonProperty
    private Calendar cppAuthorizationMSDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "provisionalTrialStartingDate")
    @JsonProperty
    private Calendar provisionalTrialStartingDate;

    @Column(name = "inIndicationAMM")
    @JsonProperty
    private Boolean inIndicationAMM = false;

    @Column(name = "outOfIndicationAMM")
    @JsonProperty
    private Boolean outOfIndicationAMM = false;

    @Column(name = "withoutAMM")
    @JsonProperty
    private Boolean withoutAMM = false;

    @Column(name = "franceAMM")
    @JsonProperty
    private Boolean franceAMM = false;

    @Column(name = "otherCountriesAMM")
    @JsonProperty
    private Boolean otherCountriesAMM = false;

    @Column(name = "cancerTrial")
    @JsonProperty
    private Boolean cancerTrial = false;

    @Column(name = "pharmaceuticalCircuitLatestVersion", columnDefinition = "text")
    @JsonProperty
    private String pharmaceuticalCircuitLatestVersion;

    @Column(name = "medicoEconomic")
    @JsonProperty
    private Boolean medicoEconomic = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualOpeningForInclusionsDate")
    @JsonProperty
    private Calendar actualOpeningForInclusionsDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "sentAgreementToPromoterDate")
    @JsonProperty
    private Calendar sentAgreementToPromoterDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "receivedAgreementSignedByAllPartiesDate")
    @JsonProperty
    private Calendar receivedAgreementSignedByAllPartiesDate;

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "trial", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private List<Arm> arms = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "trial", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private List<InclusionArm> inclusionArms = new ArrayList<>();

    @OneToMany(cascade = CascadeType.REMOVE, mappedBy = "trial", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private List<Cohort> cohorts = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trial", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private List<TrialProtocol> amendments = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trial", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private List<TrialConsent> consentments = new ArrayList<>();

    @Transient
    private List<TrialAct> acts = new ArrayList<>();

    @OneToOne(mappedBy = "trial", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JsonIgnore
    @EntityRef
    private TheoreticalCalendar theoreticalCalendar;

    @Transient
    private List<TheoreticalInvoice> theoreticalInvoices = new ArrayList<>();

    @Transient
    private List<TrialFixedCost> fixedCosts = new ArrayList<>();

    @Transient
    private List<Inclusion> patientInclusions = new ArrayList<>();

    @Column(name = "hasActualOpeningForInclusionsDate")
    @JsonProperty
    private boolean hasActualOpeningForInclusionsDate;

    @Column(name = "hasSentAgreementToPromoterDate", nullable = false)
    @JsonProperty
    private Boolean hasSentAgreementToPromoterDate = false;

    @Column(name = "hasReceivedAgreementSignedByAllPartiesDate", nullable = false)
    @JsonProperty
    private Boolean hasReceivedAgreementSignedByAllPartiesDate = false;

    @Column(name = "hasInitialEvaluationCppSessionDate", nullable = false)
    @JsonProperty
    private Boolean hasInitialEvaluationCppSessionDate = false;

    @Column(name = "hasCppFavorableOpinionMSDate", nullable = false)
    @JsonProperty
    private Boolean hasCppFavorableOpinionMSDate = false;

    @Column(name = "hasCppAuthorizationMSDate", nullable = false)
    @JsonProperty
    private Boolean hasCppAuthorizationMSDate = false;

    @Column(name = "hasProvisionalTrialStartingDate", nullable = false)
    @JsonProperty
    private Boolean hasProvisionalTrialStartingDate = false;

    @Column(name = "trialTotalEffective")
    @JsonProperty
    private Long trialTotalEffective;

    @Column(name = "favorite")
    @JsonProperty
    private Boolean favorite;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trials_2_users_favorites",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "userHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Set<User> usersFavorite = new HashSet<>();

    @Column
    @JsonProperty
    private Boolean ditepDrc;

    @Column
    private Calendar confidentialityAgreementDispatchDate;

    @Column
    private Calendar finalizationCuhAgreementDate;

    @Column
    private Boolean receivedConvention;

    @Column
    private Boolean revisedConvention;

    @Column(columnDefinition = "text")
    private String specificity;

    @Column(columnDefinition = "text")
    private String trialStatus;

    @Column(columnDefinition = "text")
    private String treatmentLine;

    @Column(columnDefinition = "text")
    private String treatmentLineDetails;

    @Column
    private Boolean agreementReceiptConfidentiality;

    @Transient
    private String comment;

    //// transient fields for trial table filters ////
    @Transient
    private String trialSiteHhhIdWithNames;

    @Transient
    private String illnessStateHhhIdWithNames;

    @Transient
    private String organFamiliesHhhIdWithName;

    @Transient
    private String organsHhhIdWithName;


    @Column(columnDefinition = "text")
    private String pv;

    @Column(columnDefinition = "text")
    private String funding;

    @Column(columnDefinition = "text")
    private Boolean isFunding;

    @Column
    private Integer totalTrialStaff;

    @Column(columnDefinition = "text")
    private String establishmentRole;

    private int patientIncludedState;
    private String trialConventionTypes;
    private String trialConventionSignatureByPromoterDates;
    private String trialCoInvestigatorsNames;
    private Integer inclusionsNumber;
    private String trialSiteLiaisonPIs;
    private String trialSiteLiaisonCRA1s;

    @ManyToMany
    @JoinTable(name = "trial_molecular_anomaly_types")
    
    private Set<MolecularAnomalyType> molecularAnomalyTypes = new HashSet<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "creator_hhhId", updatable = false)
    
    private User creator;

    private Boolean niceAuthorization;

    private Boolean hasANSMAuthorization;

    private Boolean hasCPPAuthorization;

    @OneToMany(mappedBy = "trial", cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    private Collection<FileEntity> trialFiles = new ArrayList<>();

    @Column(name = "creationDate", updatable = false)
    @CreationTimestamp
    private Calendar creationDate;

    @Column(columnDefinition = "integer default 0")
    private Long numberOfConsultations;

    @Column(columnDefinition = "boolean default false")
    private Boolean isSelectedForMobileApplication;

    @OneToMany(mappedBy = "trial", cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    
    private Collection<TrialMessage> messages = new ArrayList<>();

    @Column(columnDefinition = "text")
    private String trialObjectives;

    @JsonIgnore
    @OneToMany(mappedBy = "trial", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    private Collection<OtherTheoreticalInvoiceDate> otherTheoreticalInvoiceDates = new ArrayList<>();

    private Boolean arc1confidentialityAgreementSigned;

    private Boolean arc2confidentialityAgreementSigned;

    @JsonIgnore
    @OneToMany(mappedBy = "trial", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    private Collection<OtherLastCppAmendmentDate> otherLastCppAmendmentDates = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trial", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<TrialFeasibilityService> services = new ArrayList<>();

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @PrimaryKeyJoinColumn
    
    private TrialIdentificationInformationGeneral trialIdentificationInformationGeneral;

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TrialAdministrativeFeasibilityInformation trialAdministrativeFeasibilityInformation;

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TrialAdministrativeCecInformation trialAdministrativeCecInformation;

    @OneToOne(mappedBy = "trial", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private TrialAdministrativeDatesInformation trialAdministrativeDatesInformation;

    @Transient
    private com.ads.Investigationintranet.domain.inclusion.State patientState;


    @Transient
    private long preInclusionNumber;


}
