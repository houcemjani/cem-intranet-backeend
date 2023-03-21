package com.ads.Investigationintranet.domain.establishment;

import com.ads.Investigationintranet.domain.Establishment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_establishment_department")
public class EstablishmentDepartment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name", unique = true)
    private String name;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;

    public EstablishmentDepartment(long hhhId, String name) {
        this.hhhId = hhhId;
        this.name = name;
    }

}
