package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.entity.Organ;
import com.ads.Investigationintranet.entity.OrganFamily;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.dozer.Mapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_discpline",
        uniqueConstraints = @UniqueConstraint(columnNames = {"trial_id"}))

public class TrialDisciplineIdentification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @ToString.Exclude
    @JoinColumn(name = "trial_id")
    private Trial trial;

    @Column(name = "illnessClassification")
    @JsonProperty
    private String illnessClassification;

    @Column(name = "interventionalProtocol")
    @JsonProperty
    private String interventionalProtocol;

    @Mapping("illnessStates.illnessStates")
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_discpline_2_illnessStates",
            joinColumns = {@JoinColumn(name = "trialDisciplineHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "illnessStateHhhid", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<IllnessState> illnessStates = new ArrayList<>();

    @Column(name = "illnessStateOtherValue")
    @JsonProperty
    private String illnessStateOtherValue;

    @Mapping("organFamilies.organFamilies")
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_discpline_2_organ_families",
            joinColumns = {@JoinColumn(name = "trialDisciplineHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "organFamilyHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<OrganFamily> organFamilies = new ArrayList<>();

    @Mapping("organs.organs")
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_discpline_2_organs",
            joinColumns = {@JoinColumn(name = "trialDisciplineHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "organHhhId", referencedColumnName = "hhhId")})
    
    @OrderBy("hhhId ASC")
    private Collection<Organ> organs = new ArrayList<>();

    @Column(name = "organOtherValue")
    @JsonProperty
    private String organOtherValue;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_discpline_2_trial_types",
            joinColumns = {@JoinColumn(name = "trialDisciplineHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "trialTypeHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<TrialType> trialTypes;

    @Column(name = "researchTypeOtherValue")
    @JsonProperty
    private String researchTypeOtherValue;

    @Column(name = "researchFieldOtherValue")
    @JsonProperty
    private String researchFieldOtherValue;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "researchNatureHhhid")
    
    @JsonProperty
    private ResearchNature researchNature;

    @Column(name = "researchNatureOtherValue")
    @JsonProperty
    private String researchNatureOtherValue;

    @Mapping("interventionTypes.interventionTypes")
    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_discpline_2_interventionTypes",
            joinColumns = {@JoinColumn(name = "trialDisciplineHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "interventionTypeHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<InterventionType> interventionTypes = new ArrayList<>();

    @Column(name = "interventionTypeOtherValue")
    @JsonProperty
    private String interventionTypeOtherValue;

    @ManyToMany(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinTable(name = "ig_trial_discpline_2_metastatic_lines",
            joinColumns = {@JoinColumn(name = "trialDisciplineHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "metastaticLineHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    
    @JsonIgnore
    private Collection<MetastaticLine> metastaticLines = new ArrayList<>();

}

