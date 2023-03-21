package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
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
@Table(name = "ig_trial_feasibility_service")
public class TrialFeasibilityService  {

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
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @Column(name = "comment")
    @JsonProperty
    private String comment;

}
