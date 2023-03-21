package com.ads.Investigationintranet.domain.trial;


import com.ads.Investigationintranet.domain.counterParts.CounterPartReference;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_counter_part")

public class TrialCounterPart  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    @JsonProperty
    private String code;

    @Column(name = "description")
    @JsonProperty
    private String description;

    @Column
    private Boolean attachedToVisit;

    @Column(name = "isInvoiceable")
    @JsonProperty
    private boolean invoiceable;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "counterPartReferenceHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private CounterPartReference counterPartReference;

    @Column(name = "numberOfUnits", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal numberOfUnits = BigDecimal.valueOf(1.0);

    @Column(name = "priceTotal", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal priceTotal = BigDecimal.valueOf(0.0);

    @Column
    private String internalAccountNumber;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentStateHhhid")
    @JsonProperty
    private TrialFixedCostPaymentState paymentState;

    @Column(columnDefinition = "boolean default false")
    private boolean freeSS;

    @Transient
    private String inclusionNumber;

    @Transient
    private LocalDate visitDate;

    @Transient
    private String visitName;

    @Transient
    private String inclusionPreScreeningIdentifier;

    @Transient
    private String inclusionScreeningIdentifier;

}
