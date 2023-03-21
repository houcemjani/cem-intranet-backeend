package com.ads.Investigationintranet.domain.operationalAct;

import com.ads.Investigationintranet.domain.act.ActCategory;
import com.ads.Investigationintranet.domain.act.ReferenceAct;
import com.ads.Investigationintranet.domain.fixedCost.ReferenceFixedCost;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ig_operational_act")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OperationalAct {
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "actCategoryHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private ActCategory actCategory;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_operational_acts_2_operational_reference_acts",
            joinColumns = {@JoinColumn(name = "operationalActHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "referenceActHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<ReferenceAct> referenceActs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_operational_acts_2_operational_reference_fixed_costs",
            joinColumns = {@JoinColumn(name = "operationalActHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "referenceFixedCostHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<ReferenceFixedCost> referenceFixedCosts = new ArrayList<>();

    @Column
    private Boolean visible;

}
