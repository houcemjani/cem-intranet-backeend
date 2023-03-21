package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_amendment_service")
public class AmendmentServiceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "agreementDate")
    @JsonProperty
    private Calendar agreementDate;

    @ManyToOne()
    @JoinColumn(name = "trialProtocolHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private TrialProtocol trialProtocol;

}
