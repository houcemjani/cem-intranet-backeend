package com.ads.Investigationintranet.domain.inclusion.calendar;

import com.ads.Investigationintranet.domain.trial.Arm;
import com.ads.Investigationintranet.domain.trial.TheoreticalCalendar;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TheoreticalVisitSnapshot {

    @Column(name = "theoretical_visit_hhhId")
    private Long hhhId;
    @Column(name = "theoretical_visit_name")
    private String name;
    private Integer plusHowManyDays;
    private Integer plusHowManyWeeks;
    private Integer plusHowManyMonths;
    private Integer plusHowManyYears;
    private Boolean beforeInclusion;
    private Boolean inInclusion;
    private Boolean afterInclusion;
    private Boolean plusHowManyDaysDefined;
    private Integer periodMargin;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theoretical_calendar_id")
    private TheoreticalCalendar theoreticalCalendar;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arm_id")
    private Arm arm;

}
