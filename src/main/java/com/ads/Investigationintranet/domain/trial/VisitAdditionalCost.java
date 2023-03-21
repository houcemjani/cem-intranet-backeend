package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.trial.version.AdditionalCostId;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity

@Table(name = "visit_additional_cost")
@Data
public class VisitAdditionalCost {


    @EmbeddedId
    @Column(insertable = false, updatable = false)
    private AdditionalCostId id;

    @Column
    private Long trialHhhId;

    @Column
    private String contractType;

    @Column
    private String type;

    @Column
    private String additionalCostName;

    @Column
    private String additionalCostCategoryName;

    @Column
    private Boolean invoiceable;

    @Column
    private Boolean optional = false;

    @Column
    private BigDecimal pricePerUnit;

    @Column
    private String internalAccountNumber;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @Transient
    private Long hhhId;

    @Transient
    private String additionalCostType;

    @Column
    private Boolean onPrescription;

    @Column
    private Boolean externalFromCentre;

    @Column
    private Boolean operationalDetail;

    @Transient
    private boolean isFromAOP = false;

    @Transient
    private Long trialOperationalActHhhId;


}
