
package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.trial.ReportsTrialSiteLiaison;
import com.ads.Investigationintranet.entity.ReportsTrial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_inclusions")
public class ReportsInclusion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Temporal(TemporalType.DATE)
    @Column(name = "initialConsentSignatureDate")
    private Calendar initialConsentSignatureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "inclusionDate")
    private Calendar inclusionDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "referrerInvestigatorHumanResourceHhhid")
    private HumanResource referrerInvestigator;

    @Temporal(TemporalType.DATE)
    @Column(name = "screenFailureDate")
    private Calendar screenFailureDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "trialTreatmentStartDate")
    private Calendar trialTreatmentStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "followupEndDate")
    private Calendar followupEndDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "preScreeningDate")
    private Calendar preScreeningDate;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientHhhid")
    private ReportsPatient patient;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "trialHhhid")
    private ReportsTrial trial;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "trialSiteHhhId")
    private ReportsTrialSiteLiaison trialSiteLiaison;

}
