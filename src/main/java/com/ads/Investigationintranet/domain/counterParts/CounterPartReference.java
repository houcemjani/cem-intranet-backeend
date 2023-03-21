package com.ads.Investigationintranet.domain.counterParts;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_counter_part_reference")
public class CounterPartReference  {
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

    @Column(name = "invoiceable")
    @JsonProperty
    private boolean invoiceable;

    @Column(name = "counterPartCategoryOtherValue")
    @JsonProperty
    private String counterPartCategoryOtherValue;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @Mapping("pricePerUnit.currencyCode")
    @JsonProperty
    private String currencyCode;

    @Column
    private String internalAccountNumber;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "counterPartCategoryHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @JsonManagedReference
    private CounterPartCategory counterPartCategory;

    @Column(columnDefinition = "boolean default false")
    private boolean freeSS;

    @Column
    private Boolean visible;


}
