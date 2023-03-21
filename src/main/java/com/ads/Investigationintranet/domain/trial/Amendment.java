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
@Table(name = "ig_trial_amendments")
public class Amendment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "version")
    @JsonProperty
    private String version;

    @Column(name = "date")
    @JsonProperty
    private Calendar date;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialSiteLiaisonHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private TrialSiteLiaison trialSiteLiaison;

}
