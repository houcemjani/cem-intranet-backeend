

package com.ads.Investigationintranet.domain.trial;


import com.ads.Investigationintranet.domain.Patient;
import com.ads.Investigationintranet.domain.fixedCost.ReferenceFixedCost;
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
@Table(name = "ig_trial_fixed_costs")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialFixedCost {


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
    @Column
    private Boolean attachedToVisit;
    @Column
    private Boolean annualInvoicing;
    @Column(name = "isInvoiceable")
    @JsonProperty
    private boolean invoiceable;
    @Column(name = "optional", columnDefinition = "boolean default false")
    private boolean optional;
    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);
    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referenceFixedCostHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private ReferenceFixedCost referenceFixedCost;
    @Column(name = "numberOfUnits", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal numberOfUnits = BigDecimal.valueOf(1.0);
    @Column(name = "priceTotal", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal priceTotal = BigDecimal.valueOf(0.0);
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentStateHhhid")
    @JsonProperty
    private TrialFixedCostPaymentState paymentState;
    @Column
    private String internalAccountNumber;
    private String secondInternalAccountNumber;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @Column(columnDefinition = "boolean default false")
    private boolean freeSS;

    @Column
    private Boolean operationalDetail;

    @Transient
    private String inclusionNumber;

    @Transient
    private LocalDate visitDate;

    @Transient
    private String visitName;

    @Transient
    private Patient patient;

    @Transient
    private String inclusionPreScreeningIdentifier;

    @Transient
    private String inclusionScreeningIdentifier;

}
