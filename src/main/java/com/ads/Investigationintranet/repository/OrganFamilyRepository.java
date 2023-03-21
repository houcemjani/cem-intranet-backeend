package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.dto.OrganFamilyDto;
import com.ads.Investigationintranet.entity.OrganFamily;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface OrganFamilyRepository extends JpaRepository<OrganFamily,Long> {
    @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.OrganFamilyDto(o) FROM OrganFamily o")
    List<OrganFamilyDto> findAllOrganFamilies();
}
