package com.ads.Investigationintranet.domain;


import com.ads.Investigationintranet.domain.contactableMember.ContactableMember;
import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
import com.ads.Investigationintranet.domain.establishment.NumberInpatientsCurrentActive;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "ig_establishments")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Establishment  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "name")
    private String name;

    @Column(name = "number")
    private String number;

    @Column(name = "FINESSNumber")
    private String FINESSNumber;

    @Column(name = "SIRETCode")
    private String SIRETCode;

    @Column(name = "address")
    private String address;

    @Column(name = "postalCode")
    private String postalCode;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "legalRepresentative")
    private String legalRepresentative;

    @OneToMany(mappedBy = "establishment", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<ContactableMember> contactableMembers = new ArrayList<>();

    @OneToMany(mappedBy = "establishment", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("hhhId ASC")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<EstablishmentDepartment> establishmentDepartments = new ArrayList<>();

    @OneToOne(mappedBy = "establishment", cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JsonIgnore
    private NumberInpatientsCurrentActive numberInpatientsCurrentActive;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "parentEstablishmentHhhId")
    private Establishment parentEstablishment;

    @Column(name = "parent")
    private boolean parent;

}
