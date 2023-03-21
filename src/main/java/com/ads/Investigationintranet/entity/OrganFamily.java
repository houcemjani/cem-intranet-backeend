

package com.ads.Investigationintranet.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_organ_families")
public class OrganFamily  {

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

    @Column
    Boolean disabled;

    @OneToMany(mappedBy = "organFamily", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @OrderBy("hhhId ASC")
    private List<Organ> organs;

}
