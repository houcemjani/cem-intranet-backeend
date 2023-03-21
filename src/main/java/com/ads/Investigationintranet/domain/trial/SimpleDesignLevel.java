package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity

@DiscriminatorValue("LIAISON")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SimpleDesignLevel extends AbstractDesignLevel {

    @Column(name = "field_name")
    private String fieldName;

    @Column(name = "field_value")
    private String value;

    @Column(name = "active", columnDefinition = "boolean default true")
    private boolean active;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId")
    @JsonProperty
    @EntityRef
    private Trial trial;


}
