package com.ads.Investigationintranet.domain.act;

import com.ads.Investigationintranet.domain.Establishment;
import com.ads.Investigationintranet.domain.trial.TrialAct;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
@Table(name = "ig_acts_reference")
public class ReferenceAct  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    private String code;

    @Column
    private String contractType;

    @Column
    private String type;

    @Column(name = "description")
    private String description;

    @Column(name = "invoiceable")
    private boolean invoiceable;

    @Column(name = "optional", columnDefinition = "boolean default false")
    private boolean optional;

    @Column(name = "onPrescription")
    private boolean onPrescription;

    @Column(name = "externalFromCentre")
    private boolean externalFromCentre;

    @Column(name = "actCategoryOtherValue")
    private String actCategoryOtherValue;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    private BigDecimal pricePerUnit = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @Mapping("pricePerUnit.currencyCode")
    private String currencyCode;

    @Transient
    @JsonIgnore
    private List<TrialAct> acts;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actCategoryHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private ActCategory actCategory;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;

    @Column
    private String internalAccountNumber;

    @Column
    private String secondInternalAccountNumber;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @Column
    private Boolean visible = true;

    @Column
    private String nomenclature;

    @Column(columnDefinition = "boolean default false")
    private boolean freeSS;

}
