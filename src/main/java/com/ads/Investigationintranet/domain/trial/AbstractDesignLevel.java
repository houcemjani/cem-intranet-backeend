package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity

@Table(name = "ig_design_level")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "level_type")
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class AbstractDesignLevel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arm_id")
    private Arm arm;
    private int level;


}
