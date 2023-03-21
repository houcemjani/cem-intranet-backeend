package com.ads.Investigationintranet.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "ig_consent_types")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ConsentType implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "name")
    private String name;

    @Column(name = "selected")
    private Boolean selected;


}
