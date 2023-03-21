package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.HumanResource;
import com.ads.Investigationintranet.domain.Site;
import com.ads.Investigationintranet.domain.YesNoEnum;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Speciality;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_site_liaisons")
public class TrialSiteLiaison  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "siteHhhId")
    
    @JsonProperty
    private Site site;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId")
    
    @JsonProperty
    @EntityRef
    private Trial trial;

    @Column(name = "comment")
    @JsonProperty
    private String comment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "specialityHhhid")
    
    @JsonProperty
    private Speciality speciality;

    @Column(name = "numberOfCenterAllocatedByPromoter")
    @JsonProperty
    private String numberOfCenterAllocatedByPromoter;

    @Column(name = "specialityOtherValue")
    @JsonProperty
    private String specialityOtherValue;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "principalInvestigator1HumanResourceHhhid")
    
    @JsonProperty
    private HumanResource principalInvestigator1;

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ig_trial_site_liaisons_2_coInvestigators",
            joinColumns = {@JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private Collection<HumanResource> coInvestigators = new ArrayList<>();

    @Column(name = "principalInvestigatorACoordinator")
    @JsonProperty
    private boolean principalInvestigatorACoordinator;

    @Column(name = "sampleManagement")
    @JsonProperty
    private Boolean sampleManagement;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicalResearchAssistant1HumanResourceHhhid")
    
    @JsonProperty
    private HumanResource clinicalResearchAssistant1;

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ig_trial_site_liaisons_2_clinicalResearchAssistant2",
            joinColumns = {@JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private Collection<HumanResource> clinicalResearchAssistant2 = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "vigilanceResponsibleHhhId")
    
    @JsonProperty
    private HumanResource vigilanceResponsible;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "qualityResponsibleHhhId")
    
    @JsonProperty
    private HumanResource qualityResponsible;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "methodologistHhhId")
    
    @JsonProperty
    private HumanResource methodologist;

    @Temporal(TemporalType.DATE)
    @Column(name = "directorFolderReceptionDate")
    @JsonProperty
    private Calendar directorFolderReceptionDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualTrialEndDate")
    @JsonProperty
    private Calendar actualTrialEndDate;


    @Temporal(TemporalType.DATE)
    @Column(name = "firstPatientConsentSignatureDate")
    @JsonProperty
    private Calendar firstPatientConsentSignatureDate;


    @Temporal(TemporalType.DATE)
    @Column(name = "directionInformationCourierDate")
    @JsonProperty
    private Calendar directionInformationCourierDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "completeReceiptDate")
    @JsonProperty
    private Calendar completeReceiptDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "conventionSignatureByPromoterDate")
    @JsonProperty
    private Calendar conventionSignatureByPromoterDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "conventionSignatureByCentreDate")
    @JsonProperty
    private Calendar conventionSignatureByCentreDate;

    @Column(name = "amendedAgreement")
    @JsonProperty
    private Boolean amendedAgreement;

    @Temporal(TemporalType.DATE)
    @Column(name = "amendedAgreementDate")
    @JsonProperty
    private Calendar amendedAgreementDate;

    @JsonIgnore
    @OneToMany(mappedBy = "trialSiteLiaison", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    private Collection<OtherAmendmentAgreement> otherAmendmentAgreements = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "insuranceAuthorizationDate")
    @JsonProperty
    private Calendar insuranceAuthorizationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "biologicalCollectionAuthorizationDate")
    @JsonProperty
    private Calendar biologicalCollectionAuthorizationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "financialCloseDate")
    @JsonProperty
    private Calendar financialCloseDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "provisionalProductionLaunchDate")
    @JsonProperty
    private Calendar provisionalProductionLaunchDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualProductionLaunchDate")
    @JsonProperty
    private Calendar actualProductionLaunchDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "inclusionDate")
    @JsonProperty
    @Formula("(select min(i.inclusionDate) from ig_inclusions i where i.trialSiteHhhId = hhhId )")
    
    private Calendar inclusionDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "provisionalOpeningDate")
    @JsonProperty
    private Calendar provisionalOpeningDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualOpeningDate")
    @JsonProperty
    private Calendar actualOpeningDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "provisionalClosingForInclusionsDate")
    @JsonProperty
    private Calendar provisionalClosingForInclusionsDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualClosingForInclusionsDate")
    @JsonProperty
    private Calendar actualClosingForInclusionsDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualFollowupEndDate")
    @JsonProperty
    private Calendar actualFollowupEndDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "theoreticalInvoiceDate")
    @JsonProperty
    private Calendar theoreticalInvoiceDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "trialEndDate")
    @JsonProperty
    private Calendar trialEndDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "trialClosingDate")
    @JsonProperty
    private Calendar trialClosingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "archiveDate")
    @JsonProperty
    private Calendar archiveDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastAuthorizationDate")
    @JsonProperty
    private Calendar lastAuthorizationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "firstInclusionDate")
    @JsonProperty
    private Calendar firstInclusionDate;

    @Column(name = "archivePlace")
    @JsonProperty
    private String archivePlace;

    @Column(name = "archiveNumber")
    @JsonProperty
    private String archiveNumber;

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ig_trial_site_liaisons_2_convention_types",
            joinColumns = {@JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "conventionTypeHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private Collection<ConventionType> conventionTypes = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trialSiteLiaison", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private List<Amendment> amendments = new ArrayList<>();

    @Column(name = "studyCRC")
    @JsonProperty
    private Boolean studyCRC;

    @Temporal(TemporalType.DATE)
    @Column(name = "auditDate")
    @JsonProperty
    private Calendar auditDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "inspectionDate")
    @JsonProperty
    private Calendar inspectionDate;

    @Column(name = "financingDrug")
    @JsonProperty
    private boolean financingDrug;

    @Column(name = "financialClose")
    @JsonProperty
    private boolean financialClose;

    @Temporal(TemporalType.DATE)
    @Column(name = "feasibilityQuestionnaireDespatchDate")
    @JsonProperty
    private Calendar feasibilityQuestionnaireDespatchDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "feasibilityQuestionnaireResponse")
    @JsonProperty
    private Calendar feasibilityQuestionnaireResponse;

    @Temporal(TemporalType.DATE)
    @Column(name = "selectionVisitDate")
    @JsonProperty
    private Calendar selectionVisitDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "internalCommittee1Date")
    @JsonProperty
    private Calendar internalCommittee1Date;

    @Temporal(TemporalType.DATE)
    @Column(name = "internalCommittee2Date")
    @JsonProperty
    private Calendar internalCommittee2Date;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "committeeDecisionHhhid")
    
    @JsonProperty
    private CommitteeDecision committeeDecision;

    @Column(name = "committeeDecisionOtherValue")
    @JsonProperty
    private String committeeDecisionOtherValue;

    @Column(name = "committeeDecisionRefusalReason")
    @JsonProperty
    private String committeeDecisionRefusalReason;

    @Column(name = "hasInspectionDate")
    @JsonProperty
    private boolean hasInspectionDate = false;

    @Column(name = "hasDirectorFolderReceptionDate")
    @JsonProperty
    private boolean hasDirectorFolderReceptionDate = false;
    @Column(name = "hasDirectionInformationCourierDate")
    @JsonProperty
    private Boolean hasDirectionInformationCourierDate = false;


    @Column(name = "hasFirstPatientConsentSignatureDate")
    @JsonProperty
    private Boolean hasFirstPatientConsentSignatureDate = false;


    @Column(name = "hasActualTrialEndDate")
    @JsonProperty
    private Boolean hasActualTrialEndDate = false;



    @Column(name = "hasCompleteReceiptDate")
    @JsonProperty
    private boolean hasCompleteReceiptDate = false;

    @Column(name = "hasConventionSignatureByPromoterDate")
    @JsonProperty
    private boolean hasConventionSignatureByPromoterDate = false;

    @Column(name = "hasConventionSignatureByCentreDate")
    @JsonProperty
    private boolean hasConventionSignatureByCentreDate = false;

    @Column(name = "hasAmendedAgreementDate")
    @JsonProperty
    private boolean hasAmendedAgreementDate = false;

    @Column(name = "hasProvisionalProductionLaunchDate")
    @JsonProperty
    private boolean hasProvisionalProductionLaunchDate = false;

    @Column(name = "hasActualProductionLaunchDate")
    @JsonProperty
    private boolean hasActualProductionLaunchDate = false;

    @Column(name = "hasProvisionalOpeningDate")
    @JsonProperty
    private boolean hasProvisionalOpeningDate = false;

    @Column(name = "hasActualOpeningDate")
    @JsonProperty
    private boolean hasActualOpeningDate = false;

    @Column(name = "hasProvisionalClosingForInclusionsDate")
    @JsonProperty
    private boolean hasProvisionalClosingForInclusionsDate = false;

    @Column(name = "hasActualClosingForInclusionsDate")
    @JsonProperty
    private boolean hasActualClosingForInclusionsDate = false;

    @Column(name = "hasActualFollowupEndDate")
    @JsonProperty
    private boolean hasActualFollowupEndDate = false;

    @Enumerated(EnumType.STRING)
    private YesNoEnum havingTheoreticalInvoiceDate;

    @Column(name = "hasTrialEndDate")
    @JsonProperty
    private boolean hasTrialEndDate = false;

    @Column(name = "hasTrialClosingDate")
    @JsonProperty
    private boolean hasTrialClosingDate = false;

    @Column(name = "hasArchiveDate")
    @JsonProperty
    private boolean hasArchiveDate = false;

    @Column(name = "hasLastAuthorizationDate")
    @JsonProperty
    private boolean hasLastAuthorizationDate = false;

    @Column(name = "hasFirstInclusionDate")
    @JsonProperty
    private boolean hasFirstInclusionDate = false;

    @Column(name = "hasAuditDate")
    @JsonProperty
    private boolean hasAuditDate = false;

    @Column(name = "hasFeasibilityQuestionnaireDespatchDate")
    @JsonProperty
    private boolean hasFeasibilityQuestionnaireDespatchDate = false;

    @Column(name = "hasFeasibilityQuestionnaireResponse")
    @JsonProperty
    private Boolean hasFeasibilityQuestionnaireResponse = false;

    @Column(name = "hasSelectionVisitDate")
    @JsonProperty
    private boolean hasSelectionVisitDate = false;

    @Column(name = "hasInternalCommittee1Date")
    @JsonProperty
    private boolean hasInternalCommittee1Date = false;

    @Column(name = "hasInternalCommittee2Date")
    @JsonProperty
    private boolean hasInternalCommittee2Date = false;

    @Column(name = "hasFinancialCloseDate")
    @JsonProperty
    private boolean hasFinancialCloseDate = false;

    @Column(name = "theoreticalNumberOfInclusions")
    @JsonProperty
    private Long theoreticalNumberOfInclusions;

    @Temporal(TemporalType.DATE)
    @Column(name = "analysisDate")
    @JsonProperty
    private Calendar analysisDate;

    @Column(name = "publicationYear1")
    @JsonProperty
    private Integer publicationYear1;

    @Column(name = "publicationYear2")
    @JsonProperty
    private Integer publicationYear2;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastPatientVisitDate")
    @JsonProperty
    private Calendar lastPatientVisitDate;

    @Column(name = "hasLastPatientVisitDate")
    @JsonProperty
    private boolean hasLastPatientVisitDate;

    @Column(name = "hasInsuranceAuthorizationDate")
    @JsonProperty
    private Boolean hasInsuranceAuthorizationDate;

    @Column(name = "hasBiologicalCollectionAuthorizationDate")
    @JsonProperty
    private Boolean hasBiologicalCollectionAuthorizationDate;

    @Column(name = "hasAnalysisDate")
    @JsonProperty
    private boolean hasAnalysisDate;

    @Column(name = "hasChecklistValidationDate")
    @JsonProperty
    private Boolean hasChecklistValidationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "accordComexDitepDate")
    @JsonProperty
    private Calendar comexDitepDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "submissionComexDitepDate")
    @JsonProperty
    private Calendar submissionComexDitepDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "cs2bDate")
    @JsonProperty
    private Calendar cs2bDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "csetReceptionDate")
    @JsonProperty
    private Calendar csetReceptionDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "checklistValidationDate")
    @JsonProperty
    private Calendar checklistValidationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "csetDate")
    @JsonProperty
    private Calendar csetDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "coordoPrcDate")
    @JsonProperty
    private Calendar coordoPrcDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "comexDitepDecisionHhhid")
    
    @JsonProperty
    private CommitteeDecision comexDitepDecisions;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "cs2bDecisionsHhhid")
    
    @JsonProperty
    private CommitteeDecision cs2bDecisions;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "csetDecisionsHhhid")
    
    @JsonProperty
    private CommitteeDecision csetDecisions;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ditepDrcDecisionHhhid")
    
    @JsonProperty
    private CommitteeDecision ditepDrcDecision;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "coordoPrcDecisionHhhid")
    
    @JsonProperty
    private CommitteeDecision coordoPrcDecision;

    @Temporal(TemporalType.DATE)
    @Column(name = "ditepDrcDate")
    @JsonProperty
    private Calendar ditepDrcDate;

    @Column
    @JsonProperty
    private String comexDitepOtherValue;

    @Column
    @JsonProperty
    private String comexDitepRefusalReason;

    @Column
    @JsonProperty
    private String ditepDrcOtherValue;

    @Column
    @JsonProperty
    private String ditepDrcRefusalReason;

    @Column
    @JsonProperty
    private String cs2bDecisionsOtherValue;

    @Column
    @JsonProperty
    private String cs2bDecisionsRefusalReason;

    @Column
    @JsonProperty
    private String csetDecisionsOtherValue;

    @Column
    @JsonProperty
    private String csetDecisionsRefusalReason;

    @Column
    @JsonProperty
    private String coordoPrcDecisionOtherValue;

    @Column
    @JsonProperty
    private String coordoPrcDecisionRefusalReason;

    @Column
    @JsonProperty
    private Long priorityNumber;

    @Column
    @JsonProperty
    private Boolean ditepDrc;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "tec1HhhId")
    
    @JsonProperty
    private HumanResource tec1;

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ig_trial_site_liaisons_2_clinicalResearchTechnician2",
            joinColumns = {@JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private Collection<HumanResource> tec2 = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "dataManager1HhhId")
    
    @JsonProperty
    private HumanResource dataManager1;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "amrHhhId")
    
    @JsonProperty
    private HumanResource amr;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "ircHhhId")
    
    @JsonProperty
    private HumanResource irc;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "gpHhhId")
    
    @JsonProperty
    private HumanResource gp;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "arcManagerHhhId")
    
    @JsonProperty
    private HumanResource arcManager;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "referentDoctorHhhId")
    
    @JsonProperty
    private HumanResource referentDoctor;

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ig_trial_site_liaisons_2_clinicalDataManager2",
            joinColumns = {@JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonProperty
    
    private Collection<HumanResource> dataManager2 = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @LazyCollection(LazyCollectionOption.FALSE)
    @JoinTable(name = "ig_trial_site_liaisons_2_clinicalProjectManager",
            joinColumns = {@JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonProperty
    private Collection<HumanResource> projectManager = new ArrayList<>();

    @Column
    private LocalDate dateOfProposalOfTheTrial;

    @Column
    private Calendar receiptFeasibilityQuestionDate;

    @Column
    private String feasibilityRetained;

    @Column
    private Calendar preSelectionDate;

    @Column
    private Calendar cecDate;

    @Column
    private Integer obtainingYear;

    @ManyToMany
    
    private Collection<Finance> finance =  new ArrayList<>();

    @Column(columnDefinition = "text")
    private String arcTelephone;


}
