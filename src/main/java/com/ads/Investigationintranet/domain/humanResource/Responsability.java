package com.ads.Investigationintranet.domain.humanResource;

import com.ads.Investigationintranet.domain.auth.Role;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_human_resource_responsabilities")
public class Responsability {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private Long hhhId;

    @Column(name = "code")
    private String code;

    @Column(name = "nameFr")
    private String nameFr;

    @Column(name = "nameEn")
    private String nameEn;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_hhhId")
    private Role attachedRole;


}
