package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Calendar;



@Entity
@Table(name = "ig_trial_administrative_regulatory",
        uniqueConstraints = @UniqueConstraint(columnNames = {"trial_id"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialAdministrativeRegulatoryInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trial_id")
    private Trial trial;

    @Column(name = "numberCTTIRS")
    private String numberCTTIRS;

    @Temporal(TemporalType.DATE)
    @Column(name = "CTTIRSDate")
    private Calendar CTTIRSDate;

    @Column(name = "hasCTTIRSDate")
    private boolean hasCTTIRSDate;

    @Column(name = "numberCNIL")
    private String numberCNIL;

    @Temporal(TemporalType.DATE)
    @Column(name = "CNILDate")
    private Calendar CNILDate;

    @Column(name = "hasCNILDate")
    private boolean hasCNILDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "cnilHhhid")
    
    private CNIL cnil;

    @Column(name = "numberClinicalTrialsGov")
    private String numberClinicalTrialsGov;

    @Column(name = "dgosNumber", columnDefinition = "text")
    private String dgosNumber;

    @Column(name = "medicoEconomic", columnDefinition = "text")
    private String medicoEconomic;

    @Column(name = "numberEUDRACT")
    private String numberEUDRACT;

    @Column(name = "IDRCB")
    private String IDRCB;

    @Column(name = "numberANSM")
    private String numberANSM;

    @Temporal(TemporalType.DATE)
    @Column(name = "ANSMAuthorizationDate")
    private Calendar ANSMAuthorizationDate;

    @Column(name = "hasANSMAuthorizationDate")
    private boolean hasANSMAuthorizationDate;

    @Column
    private LocalDate lastANSMAmendmentDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastANSMAmendmentToDate")
    private Calendar lastANSMAmendmentToDate;

    @Column
    private Boolean hasLastANSMAmendmentDate;

    @Column
    private Calendar ansmInformationDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "numberCppHhhid")
    
    private Cpp cpp;

    @Column(name = "numberCPP")
    private String numberCPP;

    @Column(name = "hasCPPSendingDate")
    private boolean hasCPPSendingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "CPPSendingDate")
    private Calendar CPPSendingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "CPPAuthorizationDate")
    private Calendar CPPAuthorizationDate;

    @Column(name = "hasCPPAuthorizationDate")
    private boolean hasCPPAuthorizationDate;

    @Column
    private LocalDate lastCPPAmendmentDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastCPPAmendmentToDate")
    private Calendar lastCPPAmendmentToDate;

    @Column
    private Boolean hasLastCPPAmendmentDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "insuranceExpiryDate")
    private Calendar insuranceExpiryDate;

    @Column(name = "hasInsuranceExpiryDate")
    private boolean hasInsuranceExpiryDate;

    @Column
    private Boolean phrcFinancement;

    @Column
    private Calendar ansmSoumissionDate;

    @Column
    private Boolean colChuCollaboration;

    @Column(columnDefinition = "text", name = "colChuCollaborationComment")
    private String colChuCollaborationComment;

}
