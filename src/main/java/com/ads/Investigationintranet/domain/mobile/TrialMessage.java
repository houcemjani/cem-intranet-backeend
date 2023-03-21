package com.ads.Investigationintranet.domain.mobile;

import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Calendar;

@Entity
@Table(name = "ig_trial_message")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialMessage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "content")
    private String content;

    @Column(name = "isSeen", columnDefinition = "boolean default false")
    private boolean isSeen;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "emitterHhhId", updatable = false)
    private User emitter;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "receiverHhhId", updatable = false)
    private User receiver;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", updatable = false)
    private Trial trial;

    @Column(name = "creationDate", updatable = false)
    @CreationTimestamp
    private Calendar creationDate;


}
