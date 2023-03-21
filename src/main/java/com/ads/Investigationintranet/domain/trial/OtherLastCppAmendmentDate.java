package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "ig_trial_other_last_cpp_amendment_date")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OtherLastCppAmendmentDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;
    @Column
    private Calendar amendmentDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

}
