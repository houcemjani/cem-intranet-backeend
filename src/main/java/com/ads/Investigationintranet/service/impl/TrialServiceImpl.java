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
    private StateRepository stateRepository;
    @Autowired
    private MetastaticLineRepository metastaticLineRepository;
    @Autowired
    private IllnessStateRepository illnessStateRepository;
    @Autowired
    private PhaseRepository phaseRepository;

//    @Cacheable(value = "clinicalTrialsCache", key = "#filters.toString() + #index + #pageNumber")
    @Override
    public Map<String, Object> getClinicalTrials(TrialFilterDto filters, int pageSize, int pageNumber) {
        Pageable pageable = PageRequest.of(pageNumber, pageSize);
        Map<String, Object> result = new HashMap<String, Object>();
        List<Long> ids;
        switch (filters.getFilterIndex()) {
            case -1:{
                result.put("list", this.trialRepository.findAllTrials(pageable).getContent());
                result.put("totalRecords", this.trialRepository.findAllTrials(pageable).getTotalElements());
                return result;
            }
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
                return result;

            }
            case 2: {
                return result;
            }
            case 3: {
                ids = filters.getPhases().stream()
                    .filter(phase -> phase.isChecked())
                    .map(phase -> phase.getId())
                    .collect(Collectors.toList());
                if (ids.size() > 0) {
                    result.put("list", this.trialRepository.findByPhasesIds(ids, pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findByPhasesIds(ids, pageable).getTotalElements());
                } else {
                    result.put("list", this.trialRepository.findAllPhasesTrials(pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findAllPhasesTrials(pageable).getTotalElements());
                }
                return result;

            }
            case 4: {
                ids = filters.getStates().stream()
                    .filter(state -> state.isChecked())
                    .map(state -> state.getId())
                    .collect(Collectors.toList());
                if (ids.size() > 0) {
                    result.put("list", this.trialRepository.findByStatesIds(ids, pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findByStatesIds(ids, pageable).getTotalElements());
                } else {
                    result.put("list", this.trialRepository.findAllStatesTrials(pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findAllStatesTrials(pageable).getTotalElements());
                }
                return result;

            }
            case 5: {
                ids = filters.getIllnessStates().stream()
                    .filter(line -> line.isChecked())
                    .map(line -> line.getId())
                    .collect(Collectors.toList());
                if (ids.size() > 0) {
                    result.put("list", this.trialRepository.findByIllnessStatesIds(ids, pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findByIllnessStatesIds(ids, pageable).getTotalElements());
                } else {
                    result.put("list", this.trialRepository.findAllIllnessStateTrials(pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findAllIllnessStateTrials(pageable).getTotalElements());
                }
                return result;
            }
            case 6: {
                ids = filters.getLines().stream()
                    .filter(line -> line.isChecked())
                    .map(line -> line.getId())
                    .collect(Collectors.toList());
                if (ids.size() > 0) {
                    result.put("list", this.trialRepository.findByMetastaticLinesIds(ids, pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findByMetastaticLinesIds(ids, pageable).getTotalElements());
                } else {
                    result.put("list", this.trialRepository.findAllMetastaticLinesTrials(pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findAllMetastaticLinesTrials(pageable).getTotalElements());
                }
                return result;
            }
            case 7: {
                if (filters.getWord() != null) {
                    if (!filters.getWord().isEmpty()) {
                        result.put("list", this.trialRepository.findByWord(filters.getWord(), pageable).getContent());
                        result.put("totalRecords", this.trialRepository.findByWord(filters.getWord(), pageable).getTotalElements());
                    } else {
                        result.put("list", this.trialRepository.findAllTrials(pageable).getContent());
                        result.put("totalRecords", this.trialRepository.findAllTrials(pageable).getTotalElements());
                    }
                } else {
                    result.put("list", this.trialRepository.findAllTrials(pageable).getContent());
                    result.put("totalRecords", this.trialRepository.findAllTrials(pageable).getTotalElements());
                }
                return result;

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

        List<OrganDto> organs = this.organRepository.findAllOrgans();
        List<StateDto> states = this.stateRepository.findStates();
        List<MetastaticLineDto> lines=this.metastaticLineRepository.findMetastaticLines();
        List<IllnessStateDto> illnessStates=this.illnessStateRepository.findIllnessStates();
        List<PhaseDto> phases=this.phaseRepository.findAllPhases();

        Map<String, Object> filters = new HashMap<>();
        filters.put("organs", organs);
        filters.put("states", states);
        filters.put("lines", lines);
        filters.put("illnessStates", illnessStates);
        filters.put("phases", phases);

        return filters;

    }

    @Scheduled(fixedRate = 86400000)
    @CacheEvict(value = {"clinicalTrialsCache","FilterListCache","OrgansByFamily,OrgansByFamilyList"}, allEntries = true)
    public void clearClinicalTrialsCache() {
    }

}
