package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.dto.OrganDto;
import com.ads.Investigationintranet.entity.Organ;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import java.util.List;

public interface OrganRepository extends JpaRepository<Organ,Long> {

    @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.OrganDto(o.hhhId,o.nameFr) From Trial t1 " +
            "JOIN TrialBase t2 ON t1.hhhId = t2.hhhId " +
            "JOIN TrialIdentificationInformationGeneral t3 On t3.trial.hhhId=t1.hhhId " +
            "JOIN TrialAdministrativeRegulatoryInformation t4 On t4.trial.hhhId=t1.hhhId " +
            "JOIN ReportsTrial t5 ON t5.hhhId = t1.hhhId " +
            "JOIN t5.organs o " +
            "WHERE t5.state.hhhId=5 ")
    List<OrganDto> findAllOrgans();


}
