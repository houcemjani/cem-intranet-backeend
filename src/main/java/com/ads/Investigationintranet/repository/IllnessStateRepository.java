package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.dto.IllnessStateDto;
import com.ads.Investigationintranet.dto.StateDto;
import com.ads.Investigationintranet.entity.IllnessState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface IllnessStateRepository extends JpaRepository<IllnessState,Long> {

  @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.IllnessStateDto(i) FROM IllnessState i where i.hhhId IN (38, 39, 40,44)")
  List<IllnessStateDto> findIllnessStates();
}
