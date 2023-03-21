package com.ads.Investigationintranet.domain.trial;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MolecularAnomalyType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "code", nullable = false)
    private String code;
    private boolean selected;


}
