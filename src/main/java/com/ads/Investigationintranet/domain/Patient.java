

package com.ads.Investigationintranet.domain;


import com.ads.Investigationintranet.domain.contact.ContactSet;
import com.ads.Investigationintranet.domain.patient.Gene;
import com.ads.Investigationintranet.domain.patient.LifeState;
import com.ads.Investigationintranet.domain.uploads.Import;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;





@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Component
@Table(name = "ig_patients")

public class Patient  {


    @Transient
    @JsonIgnore
    public static Boolean nipHide = false;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "sex")
    @JsonProperty
    private String sex;

    @Column(name = "firstName")
    @JsonProperty
    private String firstName;

    @Column(name = "middleName")
    @JsonProperty
    private String middleName;

    @Column(name = "lastName")
    @JsonProperty
    private String lastName;

    @Column(name = "birthName")
    @JsonProperty
    private String birthName;

    @Column(name = "internalIdentifier", unique = true)
    @JsonProperty
    private String internalIdentifier;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate")
    @JsonProperty
    private Calendar birthDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "deathDate")
    @JsonProperty
    private Calendar deathDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "lifeStateHhhid")
    
    @JsonProperty
    private LifeState lifeState;

    @Column(name = "addressedByExternalDoctor")
    @JsonProperty
    private Boolean addressedByExternalDoctor;

    @Column(name = "externalDoctorName")
    @JsonProperty
    private String externalDoctorName;

    @Column(name = "externalDoctorEstablishment")
    @JsonProperty
    private String externalDoctorEstablishment;

    @Transient
    private List<Inclusion> trialInclusions;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "contactSetHhhId")
    
    private ContactSet contactSet;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    
    @JsonIgnore
    private Establishment establishment;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "importHhhId", referencedColumnName = "hhhId")
    
    @JsonProperty
    private Import referencedImport;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ig_patient_genes",
            joinColumns = {@JoinColumn(name = "patientHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "geneHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    
    private Collection<Gene> genes = new ArrayList<>();

    private Boolean hasMutation;

    private Boolean hasForebodingTrial;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ig_patient_trials",
            joinColumns = {@JoinColumn(name = "patientHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    
    private Collection<Trial> forebodingTrials = new ArrayList<>();

}
