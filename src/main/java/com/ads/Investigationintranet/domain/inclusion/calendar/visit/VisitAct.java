package com.ads.Investigationintranet.domain.inclusion.calendar.visit;

import com.ads.Investigationintranet.domain.inclusion.calendar.Visit;
import com.ads.Investigationintranet.domain.trial.*;
import com.ads.Investigationintranet.domain.trial.calendar.theoreticalvisit.TheoreticalVisitAct;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_inclusion_calendar_visit_acts")

public class VisitAct  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "position")
    @JsonProperty
    private int position;

    @Column(name = "isInvoiceable")
    @JsonProperty
    private boolean invoiceable;

    @Column(name = "optional", columnDefinition = "boolean default false")
    @JsonProperty
    private boolean optional;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;

    @Column(name = "numberOfUnits", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal numberOfUnits = BigDecimal.valueOf(1.0);

    @Column(name = "priceTotal", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal priceTotal = BigDecimal.valueOf(0.0);

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "visitHhhid")

    @JsonIgnore
    @EntityRef
    private Visit visit;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "theoreticalVisitActHhhid")
    @JsonProperty
    @EntityRef
    private TheoreticalVisitAct theoreticalVisitAct;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialActHhhid")
   
    @JsonProperty
    @EntityRef
    private TrialAct trialAct;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialFixedCostHhhid")
   
    @JsonProperty
    @EntityRef
    private TrialFixedCost trialFixedCost;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialCounterPartHhhid")
    @JsonProperty
    @EntityRef
    private TrialCounterPart trialCounterPart;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialOperationalActHhhhid")

    @JsonProperty
    @EntityRef
    private TrialOperationalAct trialOperationalAct;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "realisationStateHhhid")
    
    @JsonProperty
    private VisitActRealisationState realisationState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentStateHhhid")
    
    @JsonProperty
    private VisitActPaymentState paymentState;

    @Column(name = "amendmentModificationType")
    @JsonProperty
    private String amendmentModificationType;//TODO should be enumerated.

    @Column
    private Boolean operational;

    @ManyToOne(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentVisitActHhhid")
    private VisitAct parentVisitAct;

    @OneToMany(mappedBy = "parentVisitAct", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<VisitAct> childVisitActs = new ArrayList<>();

    @Column(name = "realisationDate")
    private java.util.Calendar realisationDate;

    @Transient
    private VisitAdditionalCost visitAdditionalCost;

    @Transient
    private String inclusionPreScreeningIdentifier;

    @Transient
    private String inclusionScreeningIdentifier;

    @Transient
    private boolean freeSS;

    @Transient
    private String trialActDescription;

}
