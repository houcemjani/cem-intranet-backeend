package com.ads.Investigationintranet.domain.trial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Table(name = "ig_establishment_role")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EstablishmentRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    private String code;

    @Column(name = "nameFr")
    private String nameFr;

    @Column(name = "nameEn")
    private String nameEn;

    public EstablishmentRole(Long hhhId) {
        setHhhId(Optional.ofNullable(hhhId).orElse(0L));
    }
}
