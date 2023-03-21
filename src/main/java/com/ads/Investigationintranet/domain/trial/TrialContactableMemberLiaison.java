package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.contactableMember.ContactableMember;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
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
@Table(name = "ig_trial_contactable_member_liaisons")
public class TrialContactableMemberLiaison  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @ManyToOne(cascade = {CascadeType.DETACH, CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "contactableMemberHhhId")
    @JsonProperty
    private ContactableMember contactableMember;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "trialHhhId")
    @JsonProperty
    @EntityRef
    private Trial trial;

    @Column(name = "comment")
    @JsonProperty
    private String comment;

    private Calendar confidentialityAgreementDate;

    private Boolean confidentialityAgreementSigned;



}
