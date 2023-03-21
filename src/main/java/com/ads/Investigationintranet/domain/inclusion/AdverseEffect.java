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
@Table(name = "ig_inclusion_adverse_effects")
public class AdverseEffect  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "severity")
    @JsonProperty
    private Integer severity;

    @Temporal(TemporalType.DATE)
    @Column(name = "occurrenceDate")
    @JsonProperty
    private Calendar occurrenceDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "declarationDate")
    @JsonProperty
    private Calendar declarationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "resolutionDate")
    @JsonProperty
    private Calendar resolutionDate;

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
