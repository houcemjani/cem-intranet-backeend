package com.ads.Investigationintranet.domain.inclusion;

import com.ads.Investigationintranet.domain.Inclusion;
import com.ads.Investigationintranet.domain.inclusion.calendar.Visit;
import com.ads.Investigationintranet.domain.trial.TheoreticalCalendar;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_inclusion_calendars")
public class Calendar  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "theoreticalCalendarHhhId", referencedColumnName = "hhhId")
    private TheoreticalCalendar theoreticalCalendar;

    @OneToMany(mappedBy = "calendar", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @Fetch(FetchMode.SUBSELECT)
    private List<Visit> visits = new ArrayList<>();

    @OneToOne(mappedBy = "calendar", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    private Inclusion inclusion;

}
