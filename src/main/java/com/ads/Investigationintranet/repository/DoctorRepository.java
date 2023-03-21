package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.domain.HumanResource;
import com.ads.Investigationintranet.dto.DoctorDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DoctorRepository extends JpaRepository<HumanResource,Long> {
    @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.DoctorDto(h) FROM HumanResource h")
    List<DoctorDto> findAllDoctors();

}
