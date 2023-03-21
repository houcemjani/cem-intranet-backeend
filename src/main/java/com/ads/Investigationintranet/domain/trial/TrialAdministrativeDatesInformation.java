package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.YesNoEnum;
import com.ads.Investigationintranet.entity.Trial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ig_trial_administrative_dates_information")
public class TrialAdministrativeDatesInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long hhhId;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

    @Column
    private String conventionStatus;

    @Column(columnDefinition = "text")
    private String coordinatorName;

    @Column(columnDefinition = "text")
    private String agreementSignatoryDoctor;

    @Column(columnDefinition = "text")
    private String archiveDuration;

    @Enumerated(EnumType.STRING)
    private YesNoEnum conventionAdditionalCosts;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar actualClosingForInclusionsDate;

    @Column
    private boolean hasActualClosingForInclusionsDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar lastPatientVisitDate;

    @Column
    private boolean hasLastPatientVisitDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar actualFollowupEndDate;

    @Column
    private boolean hasActualFollowupEndDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar trialEndDate;

    @Column
    private boolean hasTrialEndDate;

    @Column
    private Integer publicationYear1;

    @Column
    private Integer publicationYear2;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar trialClosingDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar archiveDate;

    @Column
    private boolean hasTrialClosingDate;

    @Column
    private boolean hasArchiveDate;

    @Column
    private String archivePlace;

    @Column
    private String archiveNumber;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar directorFolderReceptionDate;

    @Column
    private boolean hasDirectorFolderReceptionDate;

    @Temporal(TemporalType.DATE)
    private Calendar actualTrialEndDate;

    @Column
    private Boolean hasActualTrialEndDate = false;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar firstPatientConsentSignatureDate;

    @Column
    private Boolean hasFirstPatientConsentSignatureDate = false;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar directionInformationCourierDate;

    @Column
    private Boolean hasDirectionInformationCourierDate = false;

    @Column
    private Calendar completeReceiptDate;

    @Column
    private boolean hasCompleteReceiptDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar completeSigningDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar conventionSignatureByPromoterDate;

    @Column
    private boolean hasConventionSignatureByPromoterDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar conventionSignatureByCentreDate;

    @Column
    private boolean hasConventionSignatureByCentreDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar insuranceAuthorizationDate;

    @Column
    private Boolean hasInsuranceAuthorizationDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar biologicalCollectionAuthorizationDate;

    @Column
    private Boolean hasBiologicalCollectionAuthorizationDate;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "trial_administrative_dates_2_convention_types")
    @Fetch(FetchMode.SUBSELECT)
    @OrderBy("hhhId ASC")
    
    private Set<ConventionType> conventionTypes = new HashSet<>();

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar provisionalProductionLaunchDate;

    @Column
    private boolean hasProvisionalProductionLaunchDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar actualProductionLaunchDate;

    @Column
    private boolean hasActualProductionLaunchDate;

    @Temporal(TemporalType.DATE)
    @Column
    @Formula("(select min(distinct i.inclusionDate) from ig_inclusions i where i.trialHhhId = trialHhhId)")
    
    private Calendar inclusionDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar provisionalOpeningDate;

    @Column
    private boolean hasProvisionalOpeningDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar actualOpeningDate;

    @Column
    private boolean hasActualOpeningDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar provisionalClosingForInclusionsDate;

    @Column
    private boolean hasProvisionalClosingForInclusionsDate;

    @Enumerated(EnumType.STRING)
    private YesNoEnum havingTheoreticalInvoiceDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar theoreticalInvoiceDate;

    @Column
    private Boolean amendedAgreement;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar amendedAgreementDate;

    @Column
    private boolean hasAmendedAgreementDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar analysisDate;

    @Column
    private boolean hasAnalysisDate;


    @Temporal(TemporalType.DATE)
    @Column
    private Calendar auditDate;

    @Column
    private boolean hasAuditDate = false;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar inspectionDate;

    @Column
    private boolean hasInspectionDate = false;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar checklistValidationDate;

    @Column
    private Boolean hasChecklistValidationDate = false;

    @Column
    private boolean studyCRC;

    @Column
    private String preArchiveBoxNumber;

    @Column(columnDefinition = "text")
    private String preArchiveRadius;

    @Column
    private Boolean preArchiveInvoicementIsValid;

    @Column
    private Calendar preArchiveLastInvoicementDate;

    @Column
    private String archiveBoxNumber;

    @Column
    private Calendar archiveClosingDate;

    @Column(columnDefinition = "text")
    private String destructionYear;

    @Column(columnDefinition = "text")
    private String archiveRadius;

    @Column
    private Boolean archivePharmacy;

    @Column
    private Boolean reportDestructed;

    @Column
    private Calendar promoterDestructionRequestDate;

    @Column
    private Boolean destructionValidation;

    @Column(columnDefinition = "text")
    private String conventionComment;

    @Column
    private Calendar revisedConventionDate;

    @Column
    private Calendar receivedConventionDate;

    @Column(columnDefinition = "text")
    private String crcNumber;

    @Column(columnDefinition = "text")
    private String havingTheoreticalInvoiceDateComment;

    @Column
    private Calendar sendingConventionDate;

    @Column(columnDefinition = "text")
    private String pharmacyMagazine;

    @Column
    private Calendar destructionDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar preArchiveDate;

    @Column
    private String theoreticalTrialDuration;

    @Column
    private String actualTrialDuration;

}
