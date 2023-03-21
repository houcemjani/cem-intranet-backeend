package com.ads.Investigationintranet.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "TrialManyToManyLiaisons")
public class TrialManyToManyLiaisons  {

    private static final long serialVersionUID = 47591889142809301L;

    @Id
    @Column(name = "trialId")
    private Long trialId;

    @Column(name = "illnessStates")
    private String illnessStates;

    @Column(name = "illnessStatesHhhIdWithNames")
    private String illnessStatesHhhIdWithNames;

    @Column(name = "organFamilies")
    private String organFamilies;

    @Column(name = "organFamilyHhhIds")
    private String organFamilyHhhIds;

    @Column(name = "organs")
    private String organs;

    @Column(name = "organHhhIds")
    private String organHhhIds;

    @Column(name = "organFamiliesHhhIdWithName")
    private String organFamiliesHhhIdWithName;

    @Column(name = "organsHhhIdWithName")
    private String organsHhhIdWithName;

    @Column(name = "coInvestigatorsTrial")
    private String coInvestigatorsTrial;

    @Column(name = "promoterSignatureDate")
    private String promoterSignatureDate;

    @Column(name = "conventionTypesTrial")
    private String conventionTypesTrial;

    @Column(name = "trialSiteLiaisonPIs")
    private String trialSiteLiaisonPIs;

    @Column(name = "trialSiteLiaisonCRA1s")
    private String trialSiteLiaisonCRA1s;

    @Column(name = "trialTreatmentHhhIds")
    private String trialTreatmentHhhIds;

    @Column(name = "trialTreatments")
    private String trialTreatments;

    @Column(name = "trialCommittees")
    private String trialCommittees;

    @Column(name = "treatmentExperimental")
    private String treatmentExperimental;

    @Column(name = "targetsOfTreatmentExperimentalPrincipals")
    private String targetsOfTreatmentExperimentalPrincipals;

    @Column(name = "othersTreatmentExperimentals")
    private String othersTreatmentExperimentals;

    @Column(name = "moleculesStudiedList")
    private String moleculesStudiedList;

    @Column(name = "targetsOfTreatmentExperimentals")
    private String targetsOfTreatmentExperimentals;

    @Column(name = "trialTechniqueTypeHhhIds")
    private String trialTechniqueTypeHhhIds;

    @Column(name = "trialTechniqueTypes")
    private String trialTechniqueTypes;

    @Column(name = "numberOfCentres")
    private String numberOfCentres;

    @Column(name = "metastaticLines")
    private String metastaticLines;

    @Column(name = "typeOfStudyLaw")
    private String typeOfStudyLaw;

    @Column(name = "pole")
    private String pole;

    @Column(name = "arcCoordinator")
    private String arcCoordinator;

    @Column(name = "tec1")
    private String tec1;

    @Column(name = "multiCentric")
    private String multiCentric;

    @Column(name = "specialityName")
    private String specialityName;

    @Column(name = "moleculeStudied")
    private String moleculeStudied;

    @Column(name = "minimalAge")
    private String minimalAge;

    @Column(name = "maximalAge")
    private String maximalAge;

    @Column(name = "administrationRoutes")
    private String administrationRoutes;

    @Column(name = "dmTrial")
    private String dmTrial;

    @Column(name = "therapeuticClassForDrugs")
    private String therapeuticClassForDrugs;

    @Column(name = "frequencyOfTreatmentAdministration")
    private String frequencyOfTreatmentAdministration;
}

