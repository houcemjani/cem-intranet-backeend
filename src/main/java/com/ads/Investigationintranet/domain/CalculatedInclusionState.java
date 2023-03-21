package com.ads.Investigationintranet.domain;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity

@Data
@NoArgsConstructor
@Table(name = "calculatedInclusionState")
public class CalculatedInclusionState implements Serializable {

    private static final long serialVersionUID = 475918891428093041L;
    @Id
    @Column(name = "inclusionHhhId")
    private Long inclusionHhhId;

    @Column(name = "inclusionState")
    private Long inclusionState;

    @Column(name = "inclusionStateName")
    private String inclusionStateName;

}


