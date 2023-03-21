package com.ads.Investigationintranet.domain.fixedCost;

import com.ads.Investigationintranet.domain.Establishment;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ig_fixed_cost_categories")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FixedCostCategory  {

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
    private List<ReferenceFixedCost> referenceFixedCosts;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    @JsonIgnore
    private Establishment establishment;

    @Column
    private Boolean visible = true;

}
