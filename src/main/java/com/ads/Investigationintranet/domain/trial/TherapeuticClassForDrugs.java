package com.ads.Investigationintranet.domain.trial;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ig_trial_therapeutic_class_for_drugs")
public class TherapeuticClassForDrugs  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    private String code;

    @Column(name = "nameFr")
    private String nameFr;

    @Column(name = "nameEn")
    private String nameEn;

    @Column(name = "selected")
    private Boolean selected;

    @Column(name = "important")
    private Boolean important;

    @OneToMany(mappedBy = "therapeuticClassForDrugs", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("hhhId ASC")
    private List<TherapeuticSubClassForDrugs> therapeuticSubClassForDrugs;

}
