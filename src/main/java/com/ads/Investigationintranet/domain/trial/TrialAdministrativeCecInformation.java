package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Calendar;

@Data
@NoArgsConstructor
@Entity
@Table(name = "ig_trial_administrative_cec_information")
public class TrialAdministrativeCecInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long hhhId;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

    @Column
    private Boolean completeFile;

    @Column
    private Calendar cecDate;

    @Column
    private String cecNotice;

    @Column
    private Calendar cec2Date;

    @Column(columnDefinition = "text")
    private String cecNotice2;

    @Column
    private Boolean manualLaboratory;

    @Column
    private Boolean manualLaboratoryAuthorization;

    @Column
    private Boolean manualPharmacy;

    @Column
    private Boolean manualPharmacyAuthorization;

    @Column
    private Boolean finalProtocolVersion;

    @Column
    private Boolean finalProtocolVersionAuthorization;

    @Column
    private Boolean nice;

    @Column
    private Boolean iDEOpinion;

    @Column
    private Boolean submittedCPP;

    @Column
    private Boolean submittedANSM;

    @Column
    private Boolean iDEAuthorization;

    @Column(columnDefinition = "text")
    private String manualLaboratoryComment;

    @Column(columnDefinition = "text")
    private String manualPharmacyComment;

    @Column(columnDefinition = "text")
    private String niceComment;

    @Column(columnDefinition = "text")
    private String iDEOpinionComment;

    @Column(columnDefinition = "text")
    private String ansmComment;

    @Column(columnDefinition = "text")
    private String cppComment;

    @Column
    private Boolean externalProvider;

    @Column
    private Boolean externalProviderAuthorization;

    @Column(columnDefinition = "text")
    private String externalProviderComment;

    @Column(columnDefinition = "text")
    private String finalProtocolVersionComment;

    public TrialAdministrativeCecInformation mergeWith(TrialAdministrativeCecInformation other) {
        this.completeFile = other.getCompleteFile();
        this.cecDate = other.getCecDate();
        this.cecNotice = other.getCecNotice();
        this.cec2Date = other.getCec2Date();
        this.cecNotice2 = other.getCecNotice2();
        this.manualLaboratory = other.getManualLaboratory();
        this.manualLaboratoryAuthorization = other.getManualLaboratoryAuthorization();
        this.manualPharmacy = other.getManualPharmacy();
        this.manualPharmacyAuthorization = other.getManualPharmacyAuthorization();
        this.finalProtocolVersion = other.getFinalProtocolVersion();
        this.finalProtocolVersionAuthorization = other.getFinalProtocolVersionAuthorization();
        this.nice = other.getNice();
        this.iDEOpinion = other.getIDEOpinion();
        this.submittedCPP = other.getSubmittedCPP();
        this.submittedANSM = other.getSubmittedANSM();
        this.iDEAuthorization = other.getIDEAuthorization();
        this.manualLaboratoryComment = other.getManualLaboratoryComment();
        this.manualPharmacyComment = other.getManualPharmacyComment();
        this.niceComment = other.getNiceComment();
        this.iDEOpinionComment = other.getIDEOpinionComment();
        this.ansmComment = other.getAnsmComment();
        this.cppComment = other.getCppComment();
        this.externalProvider = other.getExternalProvider();
        this.externalProviderAuthorization = other.getExternalProviderAuthorization();
        this.externalProviderComment = other.getExternalProviderComment();
        this.finalProtocolVersionComment = other.getFinalProtocolVersionComment();
        return this;
    }
}
