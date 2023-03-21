

package com.ads.Investigationintranet.domain.trial.calendar.theoreticalvisit;


import com.ads.Investigationintranet.domain.trial.TrialAct;
import com.ads.Investigationintranet.domain.trial.TrialCounterPart;
import com.ads.Investigationintranet.domain.trial.TrialFixedCost;
import com.ads.Investigationintranet.domain.trial.TrialOperationalAct;
import com.ads.Investigationintranet.domain.trial.calendar.TheoreticalVisit;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;




@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_trial_theoretical_calendar_theoretical_visit_acts")

public class TheoreticalVisitAct  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "isInvoiceable")
    @JsonProperty
    private Boolean invoiceable;

    @Column(name = "optional", columnDefinition = "boolean default false")
    @JsonProperty
    private Boolean optional;

    @Mapping("pricePerUnit.amount")
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
    @JoinColumn(name = "trialOperationalActHhhid")
    
    @JsonProperty
    @EntityRef
    private TrialOperationalAct trialOperationalAct;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "theoreticalVisitHhhid")
    
    @JsonIgnore
    @EntityRef
    private TheoreticalVisit theoreticalVisit;

    @Column(name = "amendmentModificationType")
    @JsonProperty
    private String amendmentModificationType;

    @Column
    private Boolean operational;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parentTheoreticalVisitActHhhid")
    private TheoreticalVisitAct parentTheoreticalVisitAct;

    @OneToMany(mappedBy = "parentTheoreticalVisitAct", fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<TheoreticalVisitAct> childrenTheoreticalVisitActs = new ArrayList<>();

}
