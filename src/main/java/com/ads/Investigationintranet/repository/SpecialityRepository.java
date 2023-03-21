package com.ads.Investigationintranet.repository;

import com.ads.Investigationintranet.dto.SpecialityDto;
import com.ads.Investigationintranet.entity.Speciality;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SpecialityRepository extends JpaRepository<Speciality,Long> {

    @Query("SELECT DISTINCT new com.ads.Investigationintranet.dto.SpecialityDto(s) FROM Speciality s")
    List<SpecialityDto> findAllSpecialities();
}
