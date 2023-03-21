package com.ads.Investigationintranet.entity;

import com.ads.Investigationintranet.domain.HumanResource;
import com.ads.Investigationintranet.domain.PromoterType;
import com.ads.Investigationintranet.domain.Provider;
import com.ads.Investigationintranet.domain.ReportsInclusion;
import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
import com.ads.Investigationintranet.domain.trial.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_trials")
public class ReportsTrial  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "protocolNumber", unique = true)
    private String protocolNumber;

    @Column(name = "localIdentifier", unique = true)
    private String localIdentifier;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicalResearchAssistant1HumanResourceHhhid")
    private HumanResource clinicalResearchAssistant1;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "clinicalResearchAssistant2HumanResourceHhhid")
    private HumanResource clinicalResearchAssistant2;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "vigilanceResponsibleHhhId")
    private HumanResource vigilanceResponsible;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "qualityResponsibleHhhId")
    private HumanResource qualityResponsible;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "principalInvestigator1HumanResourceHhhid")
    private HumanResource principalInvestigator1;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_trials_2_coInvestigators",
        joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
        inverseJoinColumns = {@JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<HumanResource> coInvestigators = new ArrayList<>();

    @OneToMany(mappedBy = "trial", cascade = {CascadeType.REMOVE, CascadeType.REFRESH}, orphanRemoval = true)
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ReportsInclusion> inclusions;

    @Column(name = "theoreticalNumberOfInclusions")
    private Long theoreticalNumberOfInclusions;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualProductionLaunchDate")
    private Calendar actualProductionLaunchDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "actualClosingForInclusionsDate")
    private Calendar actualClosingForInclusionsDate;

    @OneToMany(mappedBy = "trial", cascade = CascadeType.REMOVE, orphanRemoval = true)
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<ReportsTrialSiteLiaison> trialSiteLiaisons = new ArrayList<>();

    @Column(name = "multiSite")
    private boolean multiSite;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentDepartmentHhhid")
    private EstablishmentDepartment establishmentDepartment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "promoter1Hhhid")
    
    private Provider promoter1;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "promoter2Hhhid")
    
    private Provider promoter2;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "promoterTypeHhhid")
    
    private PromoterType promoterType;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_trials_2_organs",
        joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
        inverseJoinColumns = {@JoinColumn(name = "organHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Organ> organs;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_trials_2_organ_families",
        joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
        inverseJoinColumns = {@JoinColumn(name = "organFamilyHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<OrganFamily> organFamilies = new ArrayList<>();

    @Column(name = "moleculeStudied")
    private String moleculeStudied;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "researchFieldHhhid")
    
    private ResearchField researchField;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "phaseHhhid")
    
    private Phase phase;

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_trials_2_illnessStates",
            joinColumns = {@JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "illnessStateHhhid", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<IllnessState> illnessState = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "researchTypeHhhid")
    
    private ResearchType researchType;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "stateHhhid")
    private State state;

}
