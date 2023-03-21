


package com.ads.Investigationintranet.domain.trial;


import com.ads.Investigationintranet.domain.trial.calendar.TheoreticalVisit;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_theoretical_calendars")

public class TheoreticalCalendar  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private Trial trial;

    @Temporal(TemporalType.DATE)
    @Column(name = "amendmentDate")
    @JsonProperty
    private Calendar amendmentDate;

    @Column(name = "amendment")
    @JsonProperty
    private String amendment;

    @Column(name = "ivrs")
    @JsonProperty
    private Boolean ivrs;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialProtocolHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private TrialProtocol trialProtocol;

    @Transient
    private List<Arm> arms;

    @Transient
    private List<TheoreticalVisit> theoreticalVisits;

    @Column(name = "iwrs")
    private Boolean iwrs;

}
