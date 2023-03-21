package com.ads.Investigationintranet.domain.inclusion;

import com.ads.Investigationintranet.domain.Inclusion;
import com.ads.Investigationintranet.domain.inclusion.calendar.Visit;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_inclusion_vital_signs")
public class VitalSigns  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "size")
    @JsonProperty
    private Double size;

    @Column(name = "weight")
    @JsonProperty
    private Double weight;

    @Column(name = "pouls")
    @JsonProperty
    private Double pouls;

    @Column(name = "temperature")
    @JsonProperty
    private Double temperature;

    @Column(name = "bloodPressure")
    @JsonProperty
    private Double bloodPressure;

    @Column(name = "arm")
    @JsonProperty
    private String arm;

    @Column(name = "respiration")
    @JsonProperty
    private Double respiration;

    @Column(name = "saturation")
    @JsonProperty
    private Double saturation;

    @Column(name = "ecg")
    @JsonProperty
    private String ecg;

    @Column(name = "fasting")
    @JsonProperty
    private Boolean fasting;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientTrialInclusionHhhid")
    @JsonIgnore
    @EntityRef
    private Inclusion inclusion;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "visitHhhId")
    @JsonIgnore
    @EntityRef
    private Visit visit;

}
