package com.ads.Investigationintranet.domain.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "ig_contacts_countries")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Country  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "nameFr")
    private String nameFr;

    @Column(name = "iSOCodeAlpha2")
    private String iSOCodeAlpha2;

    @Column(name = "ISOCodeAlpha3")
    private String ISOCodeAlpha3;

    @Column(name = "countryCode")
    private String countryCode;

}
