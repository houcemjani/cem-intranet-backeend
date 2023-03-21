package com.ads.Investigationintranet.domain.trial;


import com.ads.Investigationintranet.domain.Establishment;
import com.ads.Investigationintranet.domain.PromoterType;
import com.ads.Investigationintranet.domain.Provider;
import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
import com.ads.Investigationintranet.entity.Phase;
import com.ads.Investigationintranet.entity.State;
import com.ads.Investigationintranet.entity.Trial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.Formula;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;



@Entity
@Table(name = "ig_trial_identification_information_general")
@Slf4j
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TrialIdentificationInformationGeneral {

    @Id
    @Column
    private long hhhId;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @ToString.Exclude
    @JoinColumn(name = "hhhId")
    private Trial trial;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "stateHhhId")
    
    private State state;

    @Column
    private boolean manualState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    
    private Establishment establishment;

    @Column
    private String localIdentifier;

    @Column
    private String protocolNumber;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "phaseHhhId")
    
    private Phase phase;

    @Column
    private Boolean concurrentTrial;

    @Column(columnDefinition = "text")
    private String concurrentTrialComment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "typeOfStudyLawHhhId")
    
    private TypeOfStudyLaw typeOfStudyLaw;

    @Column
    private Long trialObjective;

    @Column
    private String numberCentersAllocatedByPromoter;

    @Column
    private String numberOfCenterAllocatedByPromoter;

    @Column(columnDefinition = "text")
    private String inclusionDuration;

    @Column
    private Boolean isPediatricTrial;

    @Column
    private Boolean isAdultTrial;

    @Column
    private String escalationExtension;

    @Column
    private Boolean isFirstInHuman;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentRoleHhhId")
    
    private EstablishmentRole roleOfEstablishment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "poleHhhId")
    
    private Pole pole;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentDepartmentHhhId")
    
    private EstablishmentDepartment establishmentDepartment;

    @Column
    private String otherCodes;

    @Column
    private String initials;

    @Column
    private String trlMaturityLevel;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "researchTypeHhhId")
    
    private ResearchType researchType;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter1HhhId")
    
    private Provider promoter1;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "promoterTypeHhhId")
    
    private PromoterType promoterType;

    @ManyToMany(fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_identification_info_2_cro_providers")
    
    private Set<Provider> croProviders = new HashSet<>();

    @Column
    private Boolean hasMolecularPreScreening;

    @Column(name = "dateOfProposalOfTheTrial")
    private LocalDate dateOfProposalOfTheTrial;

    @Column
    private Boolean interventionResearch;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "promoter2HhhId")
    
    private Provider promoter2;

    @Column
    private boolean blinded;

    @Column
    private boolean multiSite;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "multiCentricHhhId")
    
    private MultiCentric multiCentric;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_identification_info_2_other_centers")
    @OrderBy("hhhId ASC")
    
    private Set<OtherParticipatingCenter> otherParticipatingCenters = new HashSet<>();

    @Column(columnDefinition = "text")
    private String recruitmentObjectives;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    @JoinTable(name = "trial_identification_info_2_number_of_centres")
    @OrderBy("hhhId ASC")
    
    private Set<NumberOfCentres> numberOfCentres = new HashSet<>();

    @Column(columnDefinition = "VARCHAR(7300)")
    private String name;

    @Column(columnDefinition = "text")
    private String abbreviatedName;

    @Column
    private Long theoreticalNumberOfInclusions;

    @Formula("(SELECT CASE WHEN itiig.multiSite " +
            "  THEN (SELECT sum(siteLiaison.theoreticalNumberOfInclusions)" +
            "        FROM ig_trial_site_liaisons siteLiaison " +
            "        WHERE siteLiaison.trialHhhId = itiig.hhhId) " +
            "  ELSE itiig.theoreticalNumberOfInclusions " +
            "  END " +
            "FROM ig_trial_identification_information_general itiig where itiig.hhhId = hhhId)")
    
    private Long calculatedTheoreticalNumberOfInclusions;

    @Formula("(select COALESCE(calculatedTrialState.stateId, 0) " +
            "from calculatedTrialState " +
            "where calculatedTrialState.trialId = hhhId)")
    
    private long calculatedState;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "trial_identification_info_2_research_fields")
    @OrderBy("hhhId ASC")
    
    private Collection<ResearchField> researchFields;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "trial_identification_info_2_committee")
    @OrderBy("hhhId ASC")
    
    private Collection<TrialCommittee> trialCommittees;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "trial_identification_info_2_types_methodology")
    @OrderBy("hhhId ASC")
    
    private Collection<TrialTypeMethodology> trialTypeMethodologys;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "investigatorCompanyHhhId")
    
    private InvestigatorCompany investigatorCompany;


    @Column
    private Long trialTotalEffective;

}
