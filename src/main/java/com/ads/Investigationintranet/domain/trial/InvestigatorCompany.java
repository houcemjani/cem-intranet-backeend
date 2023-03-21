package com.ads.Investigationintranet.domain.trial;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ig_trial_investigator_company")
@Data
@NoArgsConstructor
public class InvestigatorCompany {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "code")
    private String code;

    @Column(name = "nameFr")
    private String nameFr;

    @Column(name = "nameEn")
    private String nameEn;

    @Column(name = "selected")
    private Boolean selected;

    public InvestigatorCompany(long hhhId) {
        this.hhhId = hhhId;
    }
}
