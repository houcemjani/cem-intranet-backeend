package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.trial.Arm;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "ig_inclusions_crossovers")
public class InclusionCrossover {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private Long hhhId;

    @Column(name = "crossoverDate")
    @Temporal(TemporalType.DATE)
    private Calendar crossoverDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arm2HhhId", referencedColumnName = "hhhId")
    private Arm arm2;

    @Column(name = "crossoverPhase")
    private Long crossoverPhase;

    @Column(name = "crossoverEscalationExtension")
    private Long crossoverEscalationExtension;

    @Column(name = "hasCrossoverDate")
    private Boolean hasCrossoverDate = false;

    @Column(name = "crossoverCohort")
    private Long crossoverCohort;

    @Column(name = "crossoverDose")
    private Long crossoverDose;


    @Column(name = "inclusionArm2")
    private Long inclusionArm2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inclusionHhhId", referencedColumnName = "hhhId")
    private Inclusion inclusion;
}
