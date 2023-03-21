package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.inclusion.*;
import com.ads.Investigationintranet.domain.patient.Gene;
import com.ads.Investigationintranet.domain.trial.Arm;
import com.ads.Investigationintranet.domain.trial.TrialConsent;
import com.ads.Investigationintranet.domain.trial.TrialSiteLiaison;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Organ;
import com.ads.Investigationintranet.entity.OrganFamily;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_inclusions")
public class Inclusion  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "patientHhhid")
    @JsonProperty
    @EntityRef
    
    private Patient patient;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhid")
    @JsonProperty
    @EntityRef
    
    private Trial trial;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialSiteHhhId")
    @JsonProperty
    @EntityRef
    
    private TrialSiteLiaison trialSiteLiaison;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "referrerInvestigatorHumanResourceHhhid")
    
    @JsonProperty
    private HumanResource referrerInvestigator;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "preScreeningSignatoryDoctorHhhId")
    
    @JsonProperty
    private HumanResource preScreeningSignatoryDoctor;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "coInvestigatorHumanResourceHhhid")
    
    @JsonProperty
    private HumanResource coInvestigator;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "stateHhhid")
    
    @JsonProperty
    private State state;

    @Column(name = "inclusionPreScreeningIdentifier")
    @JsonProperty
    private String inclusionPreScreeningIdentifier;

    @Column(name = "inclusionIdentifier1")
    @JsonProperty
    private String inclusionIdentifier1;

    @Column(name = "inclusionIdentifier2")
    @JsonProperty
    private String inclusionIdentifier2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentSignatureType1HhhId")
    
    @EntityRef
    private ConsentType consentSignatureType1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentSignatureType2HhhId")
    
    @EntityRef
    private ConsentType consentSignatureType2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentSignatureType3HhhId")
    
    @EntityRef
    private ConsentType consentSignatureType3;

    @Temporal(TemporalType.DATE)
    @Column(name = "consentSignatureDate1")
    
    @JsonProperty
    private java.util.Calendar consentSignatureDate1;

    @Temporal(TemporalType.DATE)
    @Column(name = "consentSignatureDate2")
    
    @JsonProperty
    private java.util.Calendar consentSignatureDate2;

    @Temporal(TemporalType.DATE)
    @Column(name = "consentSignatureDate3")
    
    @JsonProperty
    private java.util.Calendar consentSignatureDate3;

    @Temporal(TemporalType.DATE)
    @Column(name = "oppositionPatientDate")
    
    @JsonProperty
    private java.util.Calendar oppositionPatientDate;

    @Column(name = "hasOppositionPatientDate", nullable = false)
    @JsonProperty
    private Boolean hasOppositionPatientDate = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "ancillaryStudySamplingDate")
    
    @JsonProperty
    private java.util.Calendar ancillaryStudySamplingDate;

    @Column(name = "hasAncillaryStudySamplingDate", nullable = false)
    @JsonProperty
    private Boolean hasAncillaryStudySamplingDate = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "mandatoryBiologicalSamplingDate")
    
    @JsonProperty
    private java.util.Calendar mandatoryBiologicalSamplingDate;

    @Column(name = "hasMandatoryBiologicalSamplingDate", nullable = false)
    @JsonProperty
    private Boolean hasMandatoryBiologicalSamplingDate = false;

    @Column(name = "ancillaryStudySampling")
    @JsonProperty
    private Boolean ancillaryStudySampling = false;

    @Column(name = "mandatoryBiologicalSampling")
    @JsonProperty
    private Boolean mandatoryBiologicalSampling = false;

    @Temporal(TemporalType.DATE)
    @Column(name = "inclusionDate")
    @JsonProperty
    private java.util.Calendar inclusionDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "preScreeningDate")
    @JsonProperty
    private java.util.Calendar preScreeningDate;

    @Column(name = "inclusionYear")
    @JsonProperty
    private int inclusionYear;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armHhhid")
    @JsonProperty
    
    @EntityRef
    private Arm arm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "armHhhid2")
    
    @EntityRef
    private Arm arm2;

    @Column(name = "inclusionArm")
    @JsonProperty
    private Long inclusionArm;

    @Column(name = "inclusionArm2")
    @JsonProperty
    private Long inclusionArm2;

    @Transient
    private List<AdverseEffect> adverseEffects;

    @Temporal(TemporalType.DATE)
    @Column(name = "initialConsentSignatureDate")
    
    @JsonProperty
    private java.util.Calendar initialConsentSignatureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "preScreeningConsentSignatureDate")
    @JsonProperty
    private java.util.Calendar preScreeningConsentSignatureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "familyConsentSignatureDate")
    @JsonProperty
    private java.util.Calendar familyConsentSignatureDate;

    @Column(name = "trialTreatmentStartYear")
    @JsonProperty
    private int trialTreatmentStartYear;

    @Temporal(TemporalType.DATE)
    @Column(name = "trialTreatmentStartDate")
    @JsonProperty
    private java.util.Calendar trialTreatmentStartDate;

    @Column(name = "trialTreatmentEndYear")
    @JsonProperty
    private int trialTreatmentEndYear;

    @Temporal(TemporalType.DATE)
    @Column(name = "trialTreatmentEndDate")
    @JsonProperty
    private java.util.Calendar trialTreatmentEndDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialTreatmentEndReasonHhhId")
    
    @JsonProperty
    private TrialTreatmentEndReason trialTreatmentEndReason;

    @Temporal(TemporalType.DATE)
    @Column(name = "inclusionTrialEndDate")
    @JsonProperty
    private java.util.Calendar inclusionTrialEndDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "inclusionTrialEndReasonHhhId")
    
    @JsonProperty
    private InclusionTrialEndReason inclusionTrialEndReason;

    @Temporal(TemporalType.DATE)
    @Column(name = "followupEndDate")
    @JsonProperty
    private java.util.Calendar followupEndDate;

    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "calendarHhhId")
    
    @JsonIgnore
    private com.ads.Investigationintranet.domain.inclusion.Calendar calendar;

    @Column(name = "positionInTrial")
    @JsonProperty
    private int positionInTrial;

    @Temporal(TemporalType.DATE)
    @Column(name = "screenFailureDate")
    @JsonProperty
    private java.util.Calendar screenFailureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "preScreeningFailureDate")
    @JsonProperty
    private java.util.Calendar preScreeningFailureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dispatchBlockDate")
    @JsonProperty
    private java.util.Calendar dispatchBlockDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "resultDate")
    @JsonProperty
    private java.util.Calendar resultDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "blocRequestDate")
    @JsonProperty
    private java.util.Calendar blocRequestDate;

    @Column(name = "result")
    @JsonProperty
    private String result;

    @Column(name = "folderNumber")
    @JsonProperty
    private String folderNumber;

    @Temporal(TemporalType.DATE)
    @Column(name = "crossoverDate")
    @JsonProperty
    private java.util.Calendar crossoverDate;

    @Column(name = "screenFailureYear")
    @JsonProperty
    private int screenFailureYear;

    @Column(name = "initials")
    @JsonProperty
    private String initials;

    @Column(name = "phase")
    @JsonProperty
    private Long phase;

    @Column(name = "escalationExtension")
    @JsonProperty
    private Long escalationExtension;

    @Column(name = "cohort")
    @JsonProperty
    private Long cohort;

    @Column(name = "manualState")
    @JsonProperty
    private boolean manualState;

    @Transient
    private String site;

    @Transient
    private java.util.Calendar lastRealizedVisitDate;

    @Column(name = "hasInitialConsentSignatureDate")
    @JsonProperty
    private boolean hasInitialConsentSignatureDate = false;

    @Column(name = "hasPreScreeningConsentSignatureDate")
    @JsonProperty
    private boolean hasPreScreeningConsentSignatureDate = false;

    @Column(name = "hasFamilyConsentSignatureDate")
    @JsonProperty
    private boolean hasFamilyConsentSignatureDate = false;

    @Column(name = "hasTrialTreatmentStartDate")
    @JsonProperty
    private boolean hasTrialTreatmentStartDate = false;

    @Column(name = "hasTrialTreatmentEndDate")
    @JsonProperty
    private boolean hasTrialTreatmentEndDate = false;

    @Column(name = "hasInclusionTrialEndDate")
    @JsonProperty
    private boolean hasInclusionTrialEndDate = false;

    @Column(name = "hasFollowupEndDate")
    @JsonProperty
    private boolean hasFollowupEndDate = false;

    @Column(name = "hasScreenFailureDate")
    @JsonProperty
    private boolean hasScreenFailureDate = false;

    @Column(name = "hasPreScreeningFailureDate")
    @JsonProperty
    private boolean hasPreScreeningFailureDate = false;

    @Column(name = "hasCrossoverDate")
    @JsonProperty
    private boolean hasCrossoverDate = false;

    @Column(name = "crossoverPhase")
    @JsonProperty
    private Long crossoverPhase;

    @Column(name = "crossoverEscalationExtension")
    @JsonProperty
    private Long crossoverEscalationExtension;

    @Column(name = "crossoverCohort")
    @JsonProperty
    private Long crossoverCohort;

    @Column(name = "crossoverDose")
    @JsonProperty
    private Long crossoverDose;

    @Column(name = "hasPreScreeningDate")
    @JsonProperty
    private boolean hasPreScreeningDate = false;

    @Column(name = "hasInclusionDate")
    @JsonProperty
    private boolean hasInclusionDate = false;

    @Column(name = "hasRandomizationDate")
    @JsonProperty
    private boolean hasRandomizationDate = false;

    @Column(name = "preScreenFailure")
    @JsonProperty
    private boolean preScreenFailure = false;

    @Column(name = "screeningFailure")
    @JsonProperty
    private Boolean screeningFailure;

    @Column(name = "hasDispatchBlockDate")
    @JsonProperty
    private boolean hasDispatchBlockDate = false;

    @Column(name = "hasResultDate")
    @JsonProperty
    private boolean hasResultDate = false;

    @Column(name = "hasBlocRequestDate")
    @JsonProperty
    private boolean hasBlocRequestDate = false;

    @Column(name = "changeDesign")
    @JsonProperty
    private Boolean changeDesign = false;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "screeningFailureCauseHhhid")
    
    @JsonProperty
    private ScreeningFailureCause screeningFailureCause;

    @Column(name = "screeningFailureCauseOtherValue")
    @JsonProperty
    private String screeningFailureCauseOtherValue;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_inclusions_2_other_consents",
            joinColumns = {@JoinColumn(name = "inclusionHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "otherConsentHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    @Fetch(FetchMode.SUBSELECT)
    private Collection<OtherConsent> otherConsents = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_inclusions_2_bloc_fields",
            joinColumns = {@JoinColumn(name = "inclusionHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "blocFieldsHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private Collection<BlocFields> blocFields = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "randomizationDate")
    
    @JsonProperty
    private java.util.Calendar randomizationDate;

    @Column(name = "preScreeningFailureReason")
    @JsonProperty
    private String preScreeningFailureReason;

    @Formula("(select calculatedInclusionState.inclusionState from calculatedInclusionState calculatedInclusionState " +
            " WHERE calculatedInclusionState.inclusionHhhId = hhhId)")
    
    private long calculatedState;

    @Mapping("organFamilies.organFamilies")
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_inclusions_2_organ_families",
            joinColumns = {@JoinColumn(name = "InclusionHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "organFamilyHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<OrganFamily> organFamilies = new ArrayList<>();

    @Mapping("organs.organs")
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_inclusions_2_organs",
            joinColumns = {@JoinColumn(name = "InclusionHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "organHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    private Collection<Organ> organs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "consentHhhId")
    
    @EntityRef
    private TrialConsent consent;

    private Boolean promoterAgreement;

    private java.util.Calendar blindDate;

    private Boolean prescreeningResult;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "ig_inclusions_2_mutations",
            joinColumns = {@JoinColumn(name = "inclusionHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "mutationHhhId", referencedColumnName = "hhhId")})
    
    private List<Gene> inclusionMutations = new ArrayList<>();

    private String receivedTreatment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "preScreeningConsentHhhId", referencedColumnName = "hhhId")
    
    @EntityRef
    private TrialConsent preScreeningConsent;
    @OneToMany(fetch = FetchType.LAZY,
            mappedBy = "inclusion",
            cascade = {CascadeType.REMOVE, CascadeType.DETACH}
    )
    private List<InclusionCrossover> crossovers = new ArrayList<>();

}
