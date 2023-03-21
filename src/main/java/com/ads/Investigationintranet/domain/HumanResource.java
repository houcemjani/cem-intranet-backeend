package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.contact.ContactSet;
import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
import com.ads.Investigationintranet.domain.humanResource.AcronymDepartment;
import com.ads.Investigationintranet.domain.humanResource.Committee;
import com.ads.Investigationintranet.domain.humanResource.Department;
import com.ads.Investigationintranet.domain.humanResource.Responsability;
import com.ads.Investigationintranet.entity.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_human_resources")
public class HumanResource  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "title")
    private String title;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastName")
    private String lastName;

    private String fullNameLF;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "departmentHhhid")
    private EstablishmentDepartment department;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_human_resource_2_etablishment_department",
            joinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "departmentHhhid", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private List<EstablishmentDepartment> departments;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "siteHhhId")
    private Site site;

    @Mapping("role.name")
    @Column(name = "role")
    private String role;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_human_resource_2_responsabilities",
            joinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "responsabilitiesHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private Collection<Responsability> responsabilities = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "specialityHhhid")
    @JsonProperty
    private Speciality speciality;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_human_resource_2_specialities",
            joinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "specialityHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private Collection<Speciality> specialities = new ArrayList<>();

    @Column(name = "specialityOtherValue")
    @JsonProperty
    private String specialityOtherValue;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "contactSetHhhId")
    private ContactSet contactSet;

    @Column(name = "rpps")
    @JsonProperty
    private String rpps;

    @Column(name = "registrationNumber")
    @JsonProperty
    private String registrationNumber;


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_human_resource_2_hr_departments",
            joinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "hrDepartmentsHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private Collection<Department> hrDepartments = new ArrayList<>();


    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_human_resource_2_committees",
            joinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "committeeHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private Collection<Committee> committees = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "acronymDepartmentHhhId")
    @JsonProperty
    private AcronymDepartment acronymDepartment;

    @Column(name = "acronymSimbad")
    @JsonProperty
    private String acronymSimbad;

    @Temporal(TemporalType.DATE)
    @Column(name = "CTTIRSDate")
    @JsonProperty
    private Calendar CTTIRSDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "entryDate")
    @JsonProperty
    private Calendar entryDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "releaseDate")
    @JsonProperty
    private Calendar releaseDate;


    @Column
    private Long beforeInclusionVisitAverageDuration;

    @Column
    private Long inInclusionVisitAverageDuration;

    @Column
    private Long afterInclusionVisitAverageDuration;

    @Column
    private String mail;

    @Column
    private String cnom;

    @Column
    private String adeli;

}

