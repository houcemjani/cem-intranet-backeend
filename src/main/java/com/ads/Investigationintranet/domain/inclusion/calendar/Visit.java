package com.ads.Investigationintranet.domain.inclusion.calendar;

import com.ads.Investigationintranet.domain.inclusion.calendar.visit.*;
import com.ads.Investigationintranet.domain.trial.Arm;
import com.ads.Investigationintranet.domain.trial.VisitDose;
import com.ads.Investigationintranet.domain.trial.calendar.TheoreticalVisit;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_inclusion_calendar_visits")
public class Visit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "shiftedDays")
    @JsonProperty
    private Integer shiftedDays = 0;

    @Column(name = "shiftingDaysEnabled")
    @JsonProperty
    private Boolean shiftingDaysEnabled = false;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("position ASC")
    @Fetch(FetchMode.SUBSELECT)
    
    private List<VisitAct> visitActs = new ArrayList<>();

    @Temporal(TemporalType.DATE)
    @Column(name = "visitDate")
    @JsonProperty
    private Calendar visitDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "registrationDate")
    @JsonProperty
    private Calendar registrationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "expectedVisitDate")
    @JsonProperty
    private Calendar expectedVisitDate;

    @Column(name = "manualExpectedVisitDate")
    @JsonProperty
    private Boolean manualExpectedVisitDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "realisationStateHhhid")
    
    @JsonProperty
    private VisitRealisationState realisationState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "visitStateHhhid")
    
    @JsonProperty
    private VisitState visitState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "paymentStateHhhid")
    
    @JsonProperty
    private VisitPaymentState paymentState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "imagingDespatchStateHhhid")
    
    @JsonProperty
    private VisitImagingDespatchState imagingDespatchState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "samplesDespatchStateHhhid")
    
    @JsonProperty
    private VisitSamplesDespatchState samplesDespatchState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "transportRefundStateHhhid")
    
    @JsonProperty
    private VisitTransportRefundState transportRefundState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "theoreticalVisitHhhid")
    
    @JsonProperty
    @EntityRef
    private TheoreticalVisit theoreticalVisit;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "calendarHhhId", referencedColumnName = "hhhId")
    
    @JsonProperty
    @EntityRef
    private com.ads.Investigationintranet.domain.inclusion.Calendar calendar;

    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;

    @Column(name = "amountTotalDue", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal amountTotalDue = BigDecimal.valueOf(0.0);

    @Column(name = "amountTotalInvoiced", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal amountTotalInvoiced = BigDecimal.valueOf(0.0);

    @Column(name = "amountTotalPaid", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal amountTotalPaid = BigDecimal.valueOf(0.0);

    @Column(name = "clonedStateOfInclusion")
    @JsonProperty
    private String clonedStateOfInclusion;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "comment")
    @JsonProperty
    private String comment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "armHhhid")
    
    @JsonProperty
    @EntityRef
    private Arm arm;

    private Integer calculatedShiftedDays;

    @Column(name = "amendment")
    @JsonProperty
    private String amendment;

    @Column(name = "amendmentModificationType")
    @JsonProperty
    private String amendmentModificationType;//TODO should be enumerated.

    @Embedded
    private TheoreticalVisitSnapshot theoreticalVisitSnapshot;

    private Boolean visitIsAdditionalTest;

    @OneToMany(mappedBy = "visit", fetch = FetchType.LAZY)
    private List<VisitDose> doses;

    @OneToMany(mappedBy = "visit", cascade = CascadeType.ALL)
    
    @Fetch(FetchMode.JOIN)
    private List<VisitShiftingHistory> shiftingHistories = new ArrayList<>();

}
