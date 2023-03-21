package com.ads.Investigationintranet.domain.inclusion.calendar.visit;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_visit_states")
public class VisitState  {
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

    @Column(name = "color")
    @JsonProperty
    private String color;

    @Column(name = "priority")
    @JsonProperty
    private long priority;

    @Column(name = "enabled")
    private Boolean enabled;

}
