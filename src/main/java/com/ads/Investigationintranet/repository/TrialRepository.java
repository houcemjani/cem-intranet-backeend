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
            "LEFT JOIN t5.organs o " +
            "LEFT JOIN t5.phase ph  " +
            "LEFT JOIN t5.principalInvestigator1 t6 " +
            "LEFT JOIN t5.clinicalResearchAssistant1 t7 " +
            "LEFT JOIN t5.clinicalResearchAssistant2 t8 " +
            "LEFT JOIN igContactSet t9 ON t7.hhhId = t9.hhhId " +
            "LEFT JOIN igContactSet t10 ON t8.hhhId = t10.hhhId " +
            "LEFT JOIN TrialDisciplineIdentification t11 ON t11.trial.hhhId = t1.hhhId " +
            "LEFT JOIN t5.illnessState i " +
            "LEFT JOIN t11.metastaticLines m " +
            "LEFT JOIN t9.phones phone1 " +
            "LEFT JOIN t10.phones phone2 " +
            "WHERE (COALESCE(:organIds, null ) IS NULL OR o.hhhId IN :organIds ) " +
            "AND (COALESCE(:phaseIds, null ) IS NULL OR ph.hhhId IN :phaseIds ) " +
            "AND (COALESCE(:metastaticLinesIds, null ) IS NULL OR m.hhhId IN :metastaticLinesIds ) " +
            "AND (COALESCE(:illnessStates, null ) IS NULL OR i.hhhId IN :illnessStates ) " +
            "AND (s.hhhId IN (:stateIds)) " +
            "AND (:word IS NULL OR t2.name LIKE CONCAT('%', :word, '%') " +
            "OR t5.protocolNumber LIKE CONCAT('%', :word, '%') " +
            "OR CONCAT(t6.firstName,' ',t6.lastName) LIKE CONCAT('%', :word, '%') " +
            "OR CONCAT(t7.firstName,' ',t7.lastName) LIKE CONCAT('%', :word, '%') " +
            "OR CONCAT(t8.firstName,' ',t8.lastName) LIKE CONCAT('%', :word, '%') " +
            "OR phone1.value LIKE CONCAT('%', :word, '%') " +
            "OR phone2.value LIKE CONCAT('%', :word, '%') " +
            "OR REPLACE(phone1.value, ' ', '') LIKE CONCAT('%', :word, '%') " +
            "OR REPLACE(phone2.value, ' ', '') LIKE CONCAT('%', :word, '%'))")
    Page<TrialDto> findByCriteria(
            @Param("organIds") List<Long> organIds,
            @Param("stateIds") List<Long> stateIds,
            @Param("phaseIds") List<Long> phaseIds,
            @Param("metastaticLinesIds") List<Long> metastaticLinesIds,
            @Param("illnessStates") List<Long> illnessStates,
            @Param("word") String word,
            Pageable pageable);

}
