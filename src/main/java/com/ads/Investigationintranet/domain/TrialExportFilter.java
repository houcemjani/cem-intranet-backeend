package com.ads.Investigationintranet.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_trial_export_filter")
public class TrialExportFilter  {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "state")
    @JsonProperty
    private long state;

    @Column(name = "phase")
    @JsonProperty
    private long phase;

    @Column(name = "promoterType")
    @JsonProperty
    private long promoterType;

    @Column(name = "site")
    @JsonProperty
    private long site;

    @Column(name = "principalInvestigator1")
    @JsonProperty
    private String principalInvestigator1;

    @Column(name = "clinicalResearchAssistant1")
    @JsonProperty
    private String clinicalResearchAssistant1;

    @Column(name = "organ")
    @JsonProperty
    private long organ;

    @Column(name = "organFamily")
    @JsonProperty
    private long organFamily;

    @Column(name = "establishment")
    @JsonProperty
    private long establishment;

    @Column(name = "actualProductionLaunchYear")
    @JsonProperty
    private long actualProductionLaunchYear;

    @Column(name = "researchType")
    @JsonProperty
    private long researchType;

    @Column(name = "researchField")
    @JsonProperty
    private long researchField;

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customExportHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private CustomExport customExport;


}
