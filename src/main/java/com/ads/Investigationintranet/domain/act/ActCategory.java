package com.ads.Investigationintranet.domain.act;

import com.ads.Investigationintranet.domain.Establishment;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "ig_act_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActCategory  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "nameFr")
    private String nameFr;

    @JsonIgnore
    @Transient
    private List<ReferenceAct> referenceActs;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    @JsonIgnore
    private Establishment establishment;

    @Column
    private boolean visible = true ;

}
