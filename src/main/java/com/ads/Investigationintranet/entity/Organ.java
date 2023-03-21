package com.ads.Investigationintranet.entity;

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
@Table(name = "ig_organs")
public class Organ  {

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

    @Column(name = "selected")
    private Boolean selected;

    private Boolean disabled;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organFamilyHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private OrganFamily organFamily;

}
