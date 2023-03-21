package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Optional;

@Entity

public class Cohort {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    public Cohort(long hhhId) {
        this.hhhId = hhhId;
    }

    public Cohort() {


    }

    public Cohort(Long hhhId, String name) {
        this.hhhId = Optional.ofNullable(hhhId).orElse(0L);
        this.name = name;
    }

    public Cohort(String value, Trial trial) {
    this.name = value;
    this.trial = trial;
    }

    public Cohort(String name) {
    this.name = name;
    }

    public long getHhhId() {
        return hhhId;
    }

    public void setHhhId(long hhhId) {
        this.hhhId = hhhId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Trial getTrial() {
        return trial;
    }

    public void setTrial(Trial trial) {
        this.trial = trial;
    }
}
