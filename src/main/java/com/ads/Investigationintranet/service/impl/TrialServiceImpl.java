package com.ads.Investigationintranet.service.impl;

import com.ads.Investigationintranet.dto.*;
import com.ads.Investigationintranet.repository.*;
import com.ads.Investigationintranet.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
@Service
public class TrialServiceImpl implements TrialService {

    @Autowired
    private TrialRepository trialRepository;
    @Autowired
    private OrganRepository organRepository;
    @Autowired
    private SpecialityRepository specialityRepository;
    @Autowired
    private DoctorRepository doctorRepository;
    @Autowired
    private PhaseRepository phaseRepository;
    @Autowired
    private OrganFamilyRepository organFamilyRepository;


    @Cacheable(value = "clinicalTrialsCache", key = "#filters.toString() + #index + #pageNumber")
    @Override
    public Map<String, Object> getClinicalTrials(TrialFilterDto filters, Integer index, int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Map<String, Object> result = new HashMap<String, Object>();

        if (filters.getOrgans() == null) {
            result.put("list", this.trialRepository.findAllOrgansTrials(pageable).getContent());
            result.put("totalRecords", this.trialRepository.findAllOrgansTrials(pageable).getTotalElements());
            return result;
        }

        List<Long> ids;
        switch (index) {
            case 0: {
                ids = filters.getOrgans().stream()
                        .filter(organ -> organ.isChecked())
                        .map(organ -> organ.getId())
                        .collect(Collectors.toList());
                if (ids.size() > 0) {
                    result.put("list", this.trialRepository.findByOrgansIds(ids, pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findByOrgansIds(ids, pageable).getTotalElements());
                } else {
                    result.put("list", this.trialRepository.findAllOrgansTrials(pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findAllOrgansTrials(pageable).getTotalElements());

                }
                return result;
            }
            case 1: {
//                ids = filters.getSpecialities().stream()
//                        .filter(speciality -> speciality.isChecked())
//                        .map(speciality -> speciality.getId())
//                        .collect(Collectors.toList());
//                if (ids.size() > 0) {
//                    result.put("list", this.trialRepository.findBySpecialitiesIds(ids, pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findBySpecialitiesIds(ids, pageable).getTotalElements());
//                } else {
//                    result.put("list", this.trialRepository.findAllSpecialitiesTrials(pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findAllSpecialitiesTrials(pageable).getTotalElements());
//                }
//                return result;
            }
            case 2: {
//                ids = filters.getDoctors().stream()
//                        .filter(doctor -> doctor.isChecked())
//                        .map(doctor -> doctor.getId())
//                        .collect(Collectors.toList());
//                if (ids.size() > 0) {
//                    result.put("list", this.trialRepository.findByDoctorsIds(ids, pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findByDoctorsIds(ids, pageable).getTotalElements());
//                } else {
//                    result.put("list", this.trialRepository.findAllDoctorsTrials(pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findAllDoctorsTrials(pageable).getTotalElements());
//                }
//                return result;
            }
            case 3: {
//                ids = filters.getPhases().stream()
//                        .filter(phase -> phase.isChecked())
//                        .map(phase -> phase.getId())
//                        .collect(Collectors.toList());
//                if (ids.size() > 0) {
//                    result.put("list", this.trialRepository.findByPhasesIds(ids, pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findByPhasesIds(ids, pageable).getTotalElements());
//                } else {
//                    result.put("list", this.trialRepository.findAllPhasesTrials(pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findAllPhasesTrials(pageable).getTotalElements());
//                }
//                return result;
            }
            case 4: {
//                if (filters.getWord() != null) {
//                    if (!filters.getWord().isEmpty()) {
//                        result.put("list", this.trialRepository.findByWord(filters.getWord(), pageable).getContent());
//                        result.put("totalRecords", this.trialRepository.findByWord(filters.getWord(), pageable).getTotalElements());
//                    } else {
//                        result.put("list", this.trialRepository.findAllTrials(pageable).getContent());
//                        result.put("totalRecords", this.trialRepository.findAllTrials(pageable).getTotalElements());
//                    }
//                } else {
//                    result.put("list", this.trialRepository.findAllTrials(pageable).getContent());
//                    result.put("totalRecords", this.trialRepository.findAllTrials(pageable).getTotalElements());
//                }
//                return result;
            }
            default: {
                break;
            }
        }
        return null;
    }

    @Cacheable(value = "FilterListCache")
    @Override
    public Map<String, Object> getFilterList() {

        List<SpecialityDto> specialities = this.specialityRepository.findAllSpecialities();
        List<PhaseDto> phases = this.phaseRepository.findAllPhases();
        List<OrganDto> organs = this.organRepository.findAllOrgans();
        List<DoctorDto> doctors = this.doctorRepository.findAllDoctors();

        Map<String, Object> filters = new HashMap<>();
        filters.put("organs", organs);
        filters.put("specialities", specialities);
        filters.put("doctors", doctors);
        filters.put("phases", phases);
        return filters;

    }

    @Scheduled(fixedRate = 86400000)
    @CacheEvict(value = {"clinicalTrialsCache","FilterListCache","OrgansByFamily,OrgansByFamilyList"}, allEntries = true)
    public void clearClinicalTrialsCache() {
    }





}
