package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.trial.TrialConsent;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_other_consents")
public class OtherConsent  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    private String name;

    @Temporal(TemporalType.DATE)
    @Column(name = "consentDate")
    @JsonProperty
    private Calendar consentDate;

    @ManyToOne
    @JoinColumn(name = "consentHhhId")
    private TrialConsent consent;

}
