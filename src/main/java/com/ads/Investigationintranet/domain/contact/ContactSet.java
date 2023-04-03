package com.ads.Investigationintranet.domain.contact;

import com.ads.Investigationintranet.domain.HumanResource;
import com.ads.Investigationintranet.domain.Patient;
import com.ads.Investigationintranet.domain.contactableMember.ContactableMember;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity(name = "igContactSet")
@Table(name = "ig_contactsets")
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ContactSet  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "comment")
    private String comment;

    @OneToMany(mappedBy = "contactSet", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @OrderBy("position ASC")

    private List<Phone> phones = new ArrayList<>();

    @OneToMany(mappedBy = "contactSet", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @OrderBy("position ASC")

    private List<Fax> faxes = new ArrayList<>();

    @OneToMany(mappedBy = "contactSet", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @OrderBy("position ASC")

    private List<Email> emails = new ArrayList<>();

    @OneToMany(mappedBy = "contactSet", cascade = {CascadeType.PERSIST, CascadeType.REMOVE, CascadeType.MERGE}, fetch = FetchType.LAZY)
    @OrderBy("position ASC")

    private List<Address> addresses = new ArrayList<>();

    @OneToOne(mappedBy = "contactSet", fetch = FetchType.LAZY)
    @JsonIgnore
    private Patient patient;

    @OneToOne(mappedBy = "contactSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private ContactableMember contactableMember;

    @OneToOne(mappedBy = "contactSet", cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JsonIgnore
    private HumanResource humanResource;

}

