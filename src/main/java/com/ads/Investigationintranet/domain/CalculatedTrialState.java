/*
 * Copyright (c) 2017.
 * This software is developed by Advanced Derivative Solutions and 3H Partners.
 * You may not copy this code or reproduce it.
 */

package com.ads.Investigationintranet.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity

@Data
@NoArgsConstructor
@Table(name = "calculatedTrialState")
public class CalculatedTrialState implements Serializable {


    private static final long serialVersionUID = 475918891428093041L;
    @Id
    @Column(name = "trialId")
    private Long trialId;

    @Column(name = "stateId")
    private Long stateId;

    @Column(name = "stateNameFr")
    private String stateNameFr;

    @Column(name = "stateNameEn")
    private String stateNameEn;
}
