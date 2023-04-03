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

    /************************************************ research all trials *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId " +
        "WHERE s.hhhId IN (5, 6, 7)")
    Page<TrialDto> findAllTrials(Pageable pageable);

    /****************************************************** research trials by word *****************************************/
    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId " +
        "LEFT JOIN t9.phones p " +
        "LEFT JOIN t10.phones ph " +
        "WHERE (t2.name LIKE CONCAT('%', :word, '%') " +
        "OR t5.protocolNumber LIKE CONCAT('%', :word, '%') " +
        "OR CONCAT(t6.firstName,' ',t6.lastName) LIKE CONCAT('%', :word, '%') " +
        "OR CONCAT(t7.firstName,' ',t7.lastName) LIKE CONCAT('%', :word, '%') " +
        "OR CONCAT(t8.firstName,' ',t8.lastName) LIKE CONCAT('%', :word, '%') " +
        "OR p.value LIKE CONCAT('%', :word, '%') " +
        "OR ph.value LIKE CONCAT('%', :word, '%') " +
        "OR REPLACE(p.value, ' ', '') LIKE CONCAT('%', :word, '%') " +
        "OR REPLACE(ph.value, ' ', '') LIKE CONCAT('%', :word, '%')) " +
        "AND s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findByWord(@Param("word") String word, Pageable pageable);

    /*********************************************** research trials by Organs **********************************************/
    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "JOIN t5.organs o " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId " +
        "WHERE s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findAllOrgansTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "JOIN t5.organs o " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "WHERE o.hhhId IN :ids "
        + "AND s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findByOrgansIds(@Param("ids") List<Long> ids, Pageable pageable);
    /************************************************ research by phases *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN t5.phase "
        + "WHERE s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findAllPhasesTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN t5.phase p "
        + "WHERE p.hhhId IN :ids "
        + "AND s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findByPhasesIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research by states *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN t5.state s "
        + "WHERE s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findAllStatesTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN t5.state s "
        + "WHERE s.hhhId IN :ids ")
    Page<TrialDto> findByStatesIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research by MetastaticLine *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN TrialDisciplineIdentification t11 ON t11.trial.hhhId = t1.hhhId "
        + "JOIN t11.metastaticLines "
        + "WHERE s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findAllMetastaticLinesTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN TrialDisciplineIdentification t11 ON t11.trial.hhhId = t1.hhhId "
        + "JOIN t11.metastaticLines m "
        + "WHERE m.hhhId IN :ids "
        + "AND s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findByMetastaticLinesIds(@Param("ids") List<Long> ids, Pageable pageable);

    /************************************************ research by illnessStates *********************************************/

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN t5.illnessState i "
        + "WHERE s.hhhId IN (5, 6, 7) " +
        "And  i.hhhId IN (38, 39, 40,44)")
    Page<TrialDto> findAllIllnessStateTrials(Pageable pageable);

    @Query(value = "SELECT DISTINCT new com.ads.Investigationintranet.dto.TrialDto(" +
        "t1.hhhId, " +
        "t2.name, " +
        "t5.protocolNumber, " +
        "t6.firstName, " +
        "t6.lastName, " +
        "t7.firstName, " +
        "t7.lastName, " +
        "t8.firstName," +
        "t8.lastName," +
        "s.hhhId," +
        "t9," +
        "t10) " +
        "FROM Trial t1 " +
        "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
        "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
        "JOIN t5.state s " +
        "LEFT JOIN t5.principalInvestigator1 t6 " +
        "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
        "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
        "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
        "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId "
        + "JOIN t5.illnessState p "
        + "WHERE p.hhhId IN :ids "
        + "AND s.hhhId IN (5, 6, 7) ")
    Page<TrialDto> findByIllnessStatesIds(@Param("ids") List<Long> ids, Pageable pageable);
}
