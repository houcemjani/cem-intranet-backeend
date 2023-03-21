package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "ig_trial_lock_page")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class TrialLockPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "local_date_time", columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @Enumerated(EnumType.STRING)
    private TrialLockPageStatus status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userHhhId")
    private User user;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trialUnlockCommentHhhId")
    private TrialUnlockComment trialUnlockComment;

    @Column(columnDefinition = "text")
    private String optionalComment;
}
