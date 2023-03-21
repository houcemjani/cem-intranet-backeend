package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.HumanResource;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

@Table(name = "ig_trial_human_resource_co_investigator")
public class TrialCoInvestigator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private Long hhhId;

    @Column(name = "endDate")
    @Temporal(TemporalType.DATE)
    private Calendar endDate;

    @Column(name = "delegationOfTasks")
    private Boolean delegationOfTasks;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHumanResourceHhhId", referencedColumnName = "hhhId")
    private TrialHumanResource trialHumanResource;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")
    
    private HumanResource coInvestigator;


}
