package com.ads.Investigationintranet.domain.trial;


import com.ads.Investigationintranet.domain.act.ActCategory;
import com.ads.Investigationintranet.domain.operationalAct.OperationalAct;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Formula;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ig_trial_operational_act")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialOperationalAct  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "description")
    private String description;

    @Column(name = "rdvDescription")
    private String rdvDescription;

    @Column(name = "isInvoiceable")
    private boolean invoiceable;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actCategoryHhhId", referencedColumnName = "hhhId")
    
    @JsonProperty
    private ActCategory actCategory;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.REFRESH)
    @JoinColumn(name = "operationalActHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private OperationalAct operationalAct;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_operational_acts_2_ig_trial_acts",
            joinColumns = {@JoinColumn(name = "trialOperationalActHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "trialActHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<TrialAct> trialActs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_operational_acts_2_ig_trial_fixed_costs",
            joinColumns = {@JoinColumn(name = "trialOperationalActHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "trialFixedCostHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<TrialFixedCost> trialFixedCosts = new ArrayList<>();

    @Formula("(select case when ((count(ff.trialOperationalActHhhId)=0) && (count(a.trialOperationalActHhhId)=0)) then true else false end " +
            "from ig_trial_operational_act aop " +
            "         left join ig_trial_operational_acts_2_ig_trial_fixed_costs ff on aop.hhhId = ff.trialOperationalActHhhId " +
            "         left join ig_trial_operational_acts_2_ig_trial_acts a on aop.hhhId = a.trialOperationalActHhhId " +
            "where aop.hhhId = hhhId)")
    
    @Column(columnDefinition = "boolean default true")
    private boolean isEmpty = true;

}
