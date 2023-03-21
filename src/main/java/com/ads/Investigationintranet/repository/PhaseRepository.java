package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.dto.PhaseDto;
import com.ads.Investigationintranet.entity.Phase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PhaseRepository extends JpaRepository<Phase,Long> {

    @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.PhaseDto(p) FROM Phase p")
    List<PhaseDto> findAllPhases();
}
