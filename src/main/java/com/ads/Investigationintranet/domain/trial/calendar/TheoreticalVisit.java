

package com.ads.Investigationintranet.domain.trial.calendar;


import com.ads.Investigationintranet.domain.inclusion.calendar.Visit;
import com.ads.Investigationintranet.domain.trial.Arm;
import com.ads.Investigationintranet.domain.trial.TheoreticalCalendar;
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

@Table(name = "ig_trial_theoretical_calendar_theoretical_visits")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class TheoreticalVisit  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "plusHowManyDays")
    @JsonProperty
    private int plusHowManyDays = 0;

    @Column(name = "plusHowManyWeeks")
    @JsonProperty
    private int plusHowManyWeeks = 0;

    @Column(name = "plusHowManyMonths")
    @JsonProperty
    private int plusHowManyMonths = 0;

    @Column(name = "plusHowManyYears")
    @JsonProperty
    private int plusHowManyYears = 0;

    @Enumerated(EnumType.STRING)
    private ExpectedDateReference expectedDateReference;

    @ManyToOne(fetch = FetchType.LAZY)
    private TheoreticalVisit dateReferenceVisit;

    @Column(name = "amountTotalDue", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal amountTotalDue = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;

    @OneToMany(mappedBy = "theoreticalVisit", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    @JsonIgnore
    @Fetch(FetchMode.SUBSELECT)
    private List<TheoreticalVisitAct> theoreticalVisitActs = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "theoreticalCalendarHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private TheoreticalCalendar theoreticalCalendar;

    @OneToMany(mappedBy = "theoreticalVisit", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<Visit> patientVisits;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "armHhhid")
    
    @JsonIgnore
    @EntityRef
    private Arm arm;

    @Column(name = "beforeInclusion")
    @JsonProperty
    private boolean beforeInclusion = false;

    @Column(name = "inInclusion")
    @JsonProperty
    private boolean inInclusion = false;

    @Column(name = "afterInclusion")
    @JsonProperty
    private boolean afterInclusion = false;

    @Column(name = "plusHowManyDaysDefined")
    @JsonProperty
    private boolean plusHowManyDaysDefined = false;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "comment")
    @JsonProperty
    private String comment;

    @Column(name = "anchorType")
    @JsonProperty
    private String anchorType;

    @Column(name = "anchorHhhId")
    @JsonProperty
    private long anchorHhhId;

    @Column(name = "amendment")
    @JsonProperty
    private String amendment;

    @Column(name = "amendmentModificationType")
    @JsonProperty
    private String amendmentModificationType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_visit_id")
    private TheoreticalVisit parentVisit;

    @OneToMany(mappedBy = "parentVisit")
    @Fetch(FetchMode.SUBSELECT)
    private List<TheoreticalVisit> childVisits = new ArrayList<>();

    @Transient
    private int sequentialNumber;

    @Transient
    private int sequentialNumberForNVisit;

    @Transient
    private boolean areSequentialNumbersInitialised = false;

    @Column(name = "visitIsAdditionalTest")
    private Boolean visitIsAdditionalTest;

    @Column()
    private Integer periodMargin = 0;

}

