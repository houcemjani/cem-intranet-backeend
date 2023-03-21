

package com.ads.Investigationintranet.domain.patient;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_patient_life_states")
public class LifeState  {

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
