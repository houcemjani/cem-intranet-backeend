package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "ig_trial_administrative_feasibility_information")
@Data
@NoArgsConstructor

public class TrialAdministrativeFeasibilityInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long hhhId;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

    @Column
    private Calendar receiptFeasibilityQuestionDate;

    @Column(columnDefinition = "text")
    private String feasibilityRetained;

    @Column
    private Calendar preSelectionDate;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_administrative_feasibility_2_finance")
    @OrderBy("hhhId ASC")
    
    private Set<Finance> finance = new HashSet<>();

    @Column(columnDefinition = "text")
    private String feasibilityComment;

    @Column
    private Boolean centerSelected;

    @Column
    private Integer obtainingYear;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar feasibilityQuestionnaireDespatchDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar feasibilityQuestionnaireResponse;

    @Column
    private boolean hasSelectionVisitDate;

    @Column
    private boolean hasFeasibilityQuestionnaireDespatchDate;

    @Column
    private Boolean hasFeasibilityQuestionnaireResponse;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar selectionVisitDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar internalCommittee1Date;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar internalCommittee2Date;

    @Column
    private boolean hasInternalCommittee1Date;

    @Column
    private boolean hasInternalCommittee2Date;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "committeeDecisionHhhId")
    
    private CommitteeDecision committeeDecision;

    @Column
    private String committeeDecisionOtherValue;

    @Column
    private String committeeDecisionRefusalReason;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar comexDitepDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "comexDitepDecisionHhhId")
    
    private CommitteeDecision comexDitepDecision;

    @Column
    private String comexDitepOtherValue;

    @Column
    private String comexDitepRefusalReason;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar submissionComexDitepDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar cs2bDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar csetDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar coordoPrcDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar ditepDrcDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "cs2bDecisionHhhId")
    
    private CommitteeDecision cs2bDecision;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "csetDecisionHhhId")
    
    private CommitteeDecision csetDecision;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "coordoPrcDecisionHhhId")
    
    private CommitteeDecision coordoPrcDecision;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ditepDrcDecisionHhhId")
    
    private CommitteeDecision ditepDrcDecision;

    @Column
    private String ditepDrcOtherValue;

    @Column
    private String ditepDrcRefusalReason;

    @Column
    private String cs2bDecisionsOtherValue;

    @Column
    private String cs2bDecisionsRefusalReason;

    @Column
    private String csetDecisionsOtherValue;

    @Column
    private String csetDecisionsRefusalReason;

    @Column
    private String coordoPrcDecisionOtherValue;

    @Column
    private String coordoPrcDecisionRefusalReason;

    @Column
    private Long priorityNumber;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar csetReceptionDate;

    @Column
    private Calendar agreementConfidentialityDispatchDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar fillingFeasibilityQuestionDate;

    @Column
    private Boolean feasibilityMeeting;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar feasibilityMeetingDate;

    @Column
    private Boolean feasibilityCenterSelected;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar feasibilityCenterSelectedDate;

    @Column
    private Boolean selectionCenterSelected;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar selectionCenterSelectedDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar committeeMeetingDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar additionalCostReceivedDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar additionalCostValidationDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar agreementReceiptDate;

    @Temporal(TemporalType.DATE)
    @Column
    private Calendar agreementSigningDate;



}
