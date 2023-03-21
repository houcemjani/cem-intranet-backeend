package com.ads.Investigationintranet.domain.counterParts;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ig_counter_part_categories")

public class CounterPartCategory  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "code")
    private String code;

    @Column(name = "nameFr")
    private String nameFr;

    @Transient
    @JsonBackReference
    private List<CounterPartReference> counterPartReferences;

}
