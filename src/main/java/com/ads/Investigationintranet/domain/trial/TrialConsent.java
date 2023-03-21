package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity

@Table(name = "ig_trial_consents")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialConsent  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialDocumentTypeHhhId")
    
    private TrialDocumentType trialDocumentType;

    @Column(name = "docmuentVersion")
    @JsonProperty
    private String documentVersion;

    private String documentName;

    @Column(name = "documentVersionDate")
    @JsonProperty
    private Calendar documentVersionDate;

    @Column(name = "amendmentVersion")
    @JsonProperty
    private String amendmentVersion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialProtocolHhhId")
    
    private TrialProtocol trialProtocol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId")
    
    private Trial trial;

}
