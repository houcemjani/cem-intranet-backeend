package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.Cohort;
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
public class ArmCohort {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cohort_id")
    private Cohort cohort;
    private Boolean cohortEnabled;

    public Optional<Cohort> getCohort() {
        return Optional.ofNullable(cohort);
    }

}
