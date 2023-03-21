package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Optional;

@Embeddable
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ArmEscaladeExtension {

    @Enumerated(EnumType.STRING)
    private EscaladeExtension escaladeExtension;
    private Boolean escalationEnabled;

    public Optional<EscaladeExtension> getEscaladeExtension() {
        return Optional.ofNullable(escaladeExtension);
    }

}
