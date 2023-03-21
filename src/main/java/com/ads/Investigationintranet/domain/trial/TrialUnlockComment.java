/*
 * Copyright (c) 2021.
 */

package com.ads.Investigationintranet.domain.trial;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ig_trial_unlock_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialUnlockComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(columnDefinition = "text")
    private String commentFr;

    @Column(columnDefinition = "text")
    private String commentEn;

}
