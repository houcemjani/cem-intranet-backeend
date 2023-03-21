package com.ads.Investigationintranet.domain.calendar;


import com.ads.Investigationintranet.domain.HumanResource;

import javax.persistence.*;

@Entity
@Table(name = "ig_schedule_colors")
public class ScheduleHumanResourcesColor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long id;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "humanResourcesHhhId", referencedColumnName = "hhhId")
    private HumanResource humanResource;

    @Column(name = "color")
    private String color;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public HumanResource getHumanResource() {
        return humanResource;
    }

    public void setHumanResource(HumanResource humanResource) {
        this.humanResource = humanResource;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
