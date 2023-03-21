package com.ads.Investigationintranet.domain.fixedCost;

import com.ads.Investigationintranet.domain.Establishment;
import com.ads.Investigationintranet.domain.trial.TrialFixedCost;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_fixed_costs_reference")
public class ReferenceFixedCost  {

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

    @Column(name = "invoiceable")
    @JsonProperty
    private boolean invoiceable;

    @Column(name = "optional", columnDefinition = "boolean default false")
    private boolean optional;

    @Column(name = "fixedCostCategoryOtherValue")
    @JsonProperty
    private String fixedCostCategoryOtherValue;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @Mapping("pricePerUnit.currencyCode")
    @JsonProperty
    private String currencyCode;

    @Transient
    @JsonIgnore
    private List<TrialFixedCost> fixedCosts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fixedCostCategoryHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @JsonManagedReference
    private FixedCostCategory fixedCostCategory;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;
    @Column
    private String internalAccountNumber;
    private String secondInternalAccountNumber;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @Column
    private Boolean visible = true;

    @Column(columnDefinition = "boolean default false")
    private boolean freeSS;

}
