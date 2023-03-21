package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.dto.TrialDto;
import com.ads.Investigationintranet.entity.Trial;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrialRepository extends JpaRepository<Trial, Long> {

    /****************************************************** research by word *****************************************/
    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 " +
            "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
            "JOIN TrialIdentificationInformationGeneral t3 On t3.trial.hhhId=t1.hhhId " +
            "JOIN TrialAdministrativeRegulatoryInformation t4 On t4.trial.hhhId=t1.hhhId " +
            "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
            "WHERE (t2.name LIKE CONCAT('%', :word, '%') " +
            "OR t3.protocolNumber LIKE CONCAT('%', :word, '%') " +
            "OR t4.numberClinicalTrialsGov  LIKE CONCAT('%', :word, '%') " +
            "OR CONCAT(t5.principalInvestigator1.firstName,' ',t5.principalInvestigator1.lastName) LIKE CONCAT('%', :word, '%')) " +
            "AND t5.state.hhhId=5 ")
    Page<TrialDto> findByWord(@Param("word") String word, Pageable pageable);

    /*********************************************** research by Organs **********************************************/
    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN t5.organs o "
            + "WHERE t5.state.hhhId=5 ")
    Page<TrialDto> findAllOrgansTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN t5.organs o "
            + "WHERE o.hhhId IN :ids "
            + "AND t5.state.hhhId=5 ")
    Page<TrialDto> findByOrgansIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research by Specialities ***************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN TrialHumanResource t7 ON  t7.hhhId =t1.trialHumanResource.hhhId  "
            + "JOIN t7.speciality "
            + "WHERE t5.state.hhhId=5 ")
    Page<TrialDto> findAllSpecialitiesTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN TrialHumanResource t7 ON t7.hhhId =t1.trialHumanResource.hhhId "
            + "JOIN t7.speciality o "
            + "WHERE o.hhhId IN :ids "
            + "AND t5.state.hhhId=5 ")
    Page<TrialDto> findBySpecialitiesIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research by phases *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN t5.phase "
            + "WHERE t5.state.hhhId=5 ")
    Page<TrialDto> findAllPhasesTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN t5.phase "
            + "WHERE t5.phase.hhhId IN :ids "
            + "AND t5.state.hhhId=5 ")
    Page<TrialDto> findByPhasesIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research by doctors *********************************************/
    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN t5.principalInvestigator1 "
            + "WHERE t5.state.hhhId=5 ")
    Page<TrialDto> findAllDoctorsTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 "
            + "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId "
            + "JOIN TrialIdentificationInformationGeneral t3 ON t3.trial.hhhId = t1.hhhId "
            + "JOIN TrialAdministrativeRegulatoryInformation t4 ON t4.trial.hhhId = t1.hhhId "
            + "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId "
            + "JOIN t5.principalInvestigator1 "
            + "WHERE t5.principalInvestigator1.hhhId IN :ids "
            + "AND t5.state.hhhId=5 ")
    Page<TrialDto> findByDoctorsIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research all trials *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(t1.hhhId ,t2.name,t3.protocolNumber,t4.numberClinicalTrialsGov," +
            "t5.principalInvestigator1.firstName,t5.principalInvestigator1.lastName ) " +
            " FROM Trial t1 " +
            "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
            "JOIN TrialIdentificationInformationGeneral t3 On t3.trial.hhhId=t1.hhhId " +
            "JOIN TrialAdministrativeRegulatoryInformation t4 On t4.trial.hhhId=t1.hhhId " +
            "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
            "WHERE  t5.state.hhhId=5 ")
    Page<TrialDto> findAllTrials(Pageable pageable);





}
