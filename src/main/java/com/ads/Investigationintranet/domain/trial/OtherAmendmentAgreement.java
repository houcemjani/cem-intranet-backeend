package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity

@Table(name = "ig_trial_other_amendment_convention")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherAmendmentAgreement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column
    private String version;

    @Column
    private Calendar amendmentSignatureDate;

    private Integer levelIndex;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "protocolVersionHhhId")
    private TrialProtocol protocol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialSiteLiaisonHhhId")
    private TrialSiteLiaison trialSiteLiaison;


}
