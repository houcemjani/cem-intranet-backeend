package com.ads.Investigationintranet.domain.calendar;

import com.ads.Investigationintranet.domain.auth.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_schedule")
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @OneToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "userHhhId", referencedColumnName = "hhhId")
    private User user;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "scheduleHhhId")
    private List<ScheduleHumanResourcesColor> favoriteHumanResources;

}
