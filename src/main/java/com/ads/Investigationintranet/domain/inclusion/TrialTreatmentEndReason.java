package com.ads.Investigationintranet.domain.inclusion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_inclusion_trial_treatment_end_reason")
public class TrialTreatmentEndReason   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "nameFr")
    @JsonProperty
    private String nameFr;


}