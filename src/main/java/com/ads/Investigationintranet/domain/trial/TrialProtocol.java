package com.ads.Investigationintranet.domain.trial;


import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;



@Entity

@Table(name = "ig_trial_protocols")
@NoArgsConstructor
@AllArgsConstructor

public class TrialProtocol  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "version")
    @JsonProperty
    private String version;

    @Column(name = "protocolVersionDate")
    @JsonProperty
    private Calendar protocolVersionDate;

    @Column(name = "amendmentVersion")
    @JsonProperty
    private String amendmentVersion;

    @Column(name = "amendmentVersionDate")
    @JsonProperty
    private Calendar amendmentVersionDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @Column(name = "ansmAuthorizationDate")
    @JsonProperty
    private Calendar ansmAuthorizationDate;

    @Column(name = "favorableOpinionCppDate")
    @JsonProperty
    private Calendar favorableOpinionCppDate;

    @Column(name = "coordoPPRCDate")
    @JsonProperty
    private Calendar coordoPPRCDate;

    @Column(name = "service")
    @JsonProperty
    private String service;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "trialProtocol", fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<AmendmentServiceEntity> services = new ArrayList<>();

    @Column(name = "coordoPPRCAgreementDate")
    @JsonProperty
    private Calendar coordoPPRCAgreementDate;

    @JsonIgnore
    @OneToMany(mappedBy = "trialProtocol", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    private Collection<TrialConsent> trialConsents = new ArrayList<>();

    @JsonIgnore
    @OneToMany(mappedBy = "protocol", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    
    private Collection<OtherAmendmentAgreement> otherAmendmentAgreements = new ArrayList<>();

    @OneToOne(mappedBy = "trialProtocol", fetch = FetchType.LAZY)
    @JsonIgnore
    private TheoreticalCalendar theoreticalCalendar;

    @OneToOne(mappedBy = "protocol", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonIgnore
    
    private TrialMethodologyIdentificationInformation trialMethodologyIdentificationInformation;

    @OneToMany(mappedBy = "protocol", fetch = FetchType.LAZY)
    @JsonIgnore
    
    private Collection<TrialInclusionExclusionCriteria> trialInclusionExclusionCriteria;

    @Column(name = "has_design", insertable = false)
    private Boolean hasDesign;

    @Enumerated(EnumType.STRING)
    private TrialProtocolType type;

    @Transient
    private long trialHhhId;

    @Column(name = "cnilHhhId")
    @JsonProperty
    private Long cnilHhhId;

}
