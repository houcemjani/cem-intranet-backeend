package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.HumanResource;
import com.ads.Investigationintranet.domain.Provider;
import com.ads.Investigationintranet.entity.Speciality;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;



@Entity
@Table(name = "ig_trial_human_resource",
        uniqueConstraints = @UniqueConstraint(columnNames = {"trialHhhId"}))
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialHumanResource {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    private Trial trial;

    @ManyToOne(cascade = {CascadeType.DETACH}, fetch = FetchType.LAZY)
    @JoinColumn(name = "principalInvestigator1HumanResourceHhhid")
    @JsonProperty
    private HumanResource principalInvestigator1;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_human_resources_2_coInvestigators",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<HumanResource> coInvestigators = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "specialityHhhid")
    @JsonProperty
    private Speciality speciality;

    @Column(name = "specialityOtherValue")
    @JsonProperty
    private String specialityOtherValue;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_human_resources_2_clinicalResearchAssistant2",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<HumanResource> clinicalResearchAssistant2 = new ArrayList<>();

    @Column(name = "principalInvestigatorACoordinator")
    @JsonProperty
    private boolean principalInvestigatorACoordinator;

    @Column(name = "sampleManagement")
    @JsonProperty
    private Boolean sampleManagement;

    @Column(name = "nationalCoordinator")
    @JsonProperty
    private String nationalCoordinator;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "clinicalResearchAssistant1HumanResourceHhhid")
    
    @JsonProperty
    private HumanResource clinicalResearchAssistant1;

    @Column(columnDefinition = "text")
    private String promoterArc1;

    @Column(columnDefinition = "text")
    private String arcTelephone;

    @Column(columnDefinition = "text")
    private String promoterArc2;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "vigilanceResponsibleHhhId")
    
    @JsonProperty
    private HumanResource vigilanceResponsible;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "qualityResponsibleHhhId")
    
    @JsonProperty
    private HumanResource qualityResponsible;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "methodologistHhhId")
    
    @JsonProperty
    private HumanResource methodologist;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "tec1HhhId")
    
    @JsonProperty
    private HumanResource tec1;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "dataManager1HhhId")
    
    @JsonProperty
    private HumanResource dataManager1;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "amrHhhId")
    
    @JsonProperty
    private HumanResource amr;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "ircHhhId")
    
    @JsonProperty
    private HumanResource irc;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "gpHhhId")
    
    @JsonProperty
    private HumanResource gp;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "arcManagerHhhId")
    
    @JsonProperty
    private HumanResource arcManager;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "referentDoctor1HhhId")
    
    @JsonProperty
    private HumanResource referentDoctor;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_human_resources_2_clinicalResearchTechnician2",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<HumanResource> tec2 = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_human_resources_2_clinicalDataManager2",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<HumanResource> dataManager2 = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_human_resources_2_clinicalProjectManager",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<HumanResource> projectManager = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referentPharmacistHhhId")
    
    @JsonProperty
    private HumanResource referentPharmacist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacoVigilanceHhhId")
    
    @JsonProperty
    private HumanResource pharmacoVigilance;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "referentLaboratoryHhhId")
    
    @JsonProperty
    private HumanResource referentLaboratory;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "arcCoordinatorHhhId")
    
    @JsonProperty
    private HumanResource arcCoordinator;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter3HhhId")
    
    @JsonProperty
    private Provider promoter3;

    @Column(columnDefinition = "text", name = "promoterProjectManager")
    private String promoterProjectManager;

    @Column
    private Boolean promoterArc1confidentialityAgreementSigned;

    @Column
    private Boolean promoterArc2confidentialityAgreementSigned;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "providerHhhId")
    
    @JsonProperty
    private Provider provider;

    @OneToMany(mappedBy = "trialHumanResource",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY)
    private Collection<TrialCoInvestigator> trialCoInvestigators = new ArrayList<>();

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "locationHhhId")
    private TrialPersonalLocation location;

}
