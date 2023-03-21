

package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity

@Table(name = "ig_trial_arms")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Arm  {

    private static final int FLAT_FIELDS = 5;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @Nationalized
    @JsonProperty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "protocol_id", updatable = false)
    private TrialProtocol protocol;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theoreticalCalendarHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private TheoreticalCalendar theoreticalCalendar;

    @Enumerated(EnumType.STRING)
    private DesignStatus status;

    @Embedded
    private ArmCohort cohort;
    @Embedded
    private ArmInclusionArm inclusionArm;
    @Embedded
    private ArmPhase phase;
    @Embedded
    private ArmEscaladeExtension escaladeExtension;

    @OneToMany(mappedBy = "arm", cascade = CascadeType.ALL, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<AbstractDesignLevel> designLevels = new ArrayList<>();

    @Column(name = "usedArmSuspended")
    @JsonProperty
    private Boolean usedArmSuspended;

}
