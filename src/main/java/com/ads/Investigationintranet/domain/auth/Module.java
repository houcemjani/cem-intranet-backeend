package com.ads.Investigationintranet.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_modules")
public class Module {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "templateRootPath")
    private String templateRootPath;

    @Column(name = "nameFr")
    private String nameFr;

    @Column(name = "nameEn")
    private String nameEn;

    @Column(name = "priority")
    private Long priority;

}
