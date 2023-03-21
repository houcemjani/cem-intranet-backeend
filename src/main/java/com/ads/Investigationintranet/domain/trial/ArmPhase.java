package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Phase;
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
public class ArmPhase {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "phase_id")

    private Phase phase;
    private Boolean phaseEnabled;

    public Optional<Phase> getPhase() {
        return Optional.ofNullable(phase);
    }

}
