package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.inclusion.InclusionArm;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Optional;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArmInclusionArm {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inclusion_arm_id")
    private InclusionArm inclusionArm;
    private Boolean inclusionArmEnabled;

    public Optional<InclusionArm> getInclusionArm() {
        return Optional.ofNullable(inclusionArm);
    }

}
