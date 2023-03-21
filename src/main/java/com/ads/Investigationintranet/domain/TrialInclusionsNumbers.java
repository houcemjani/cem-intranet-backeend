package com.ads.Investigationintranet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "trialInclusionsNumbers")
public class TrialInclusionsNumbers  {

    private static final long serialVersionUID = 47591889142809301L;

    @Id
    @Column(name = "trialId")
    private Long trialId;

    @Column(name = "inclusionsNumber")
    private int inclusionsNumber;

    @Column(name = "stateIncludedNumber")
    private int stateIncludedNumber;

}

