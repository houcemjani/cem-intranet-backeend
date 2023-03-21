package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.act.ReferenceAct;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_acts")

public class TrialAct{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    @JsonProperty
    private String code;

    @Column
    private String contractType;

    @Column
    private String type;

    @Column(name = "description")
    @JsonProperty
    private String description;

    @Column(name = "isInvoiceable")
    @JsonProperty
    private boolean invoiceable;

    @Column(columnDefinition = "boolean default false")
    private boolean optional;

    @Column(name = "onPrescription")
    @JsonProperty
    private boolean onPrescription;

    @Column(name = "externalFromCentre")
    @JsonProperty
    private boolean externalFromCentre;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;

    @Column
    private String internalAccountNumber;

    private String secondInternalAccountNumber;

    @Column(columnDefinition = "boolean default false")
    private boolean freeSS;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "referenceActHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private ReferenceAct referenceAct;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @Column
    private Boolean operationalDetail;

}
