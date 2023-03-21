package com.ads.Investigationintranet.domain.inclusion.calendar.visit;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "ig_inclusion_calendar_visit_realisation_states")
public class VisitRealisationState  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    @JsonProperty
    private String code;

    @Column(name = "nameFr")
    @JsonProperty
    private String nameFr;

    @Column(name = "nameEn")
    @JsonProperty
    private String nameEn;

}
