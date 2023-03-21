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
import java.util.Calendar;



@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_inclusion_concomitant_treatment")
public class ConcomitantTreatment  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "dosage")
    @JsonProperty
    private String dosage;

    @Temporal(TemporalType.DATE)
    @Column(name = "firstTakingDate")
    @JsonProperty
    private Calendar firstTakingDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "lastTakingDate")
    @JsonProperty
    private Calendar lastTakingDate;

    @Column(name = "administered")
    @JsonProperty
    private Boolean administered;

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
