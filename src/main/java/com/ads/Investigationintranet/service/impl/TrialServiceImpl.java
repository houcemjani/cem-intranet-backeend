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

    @Cacheable(value = "clinicalTrialsCache", key = "#filters.toString() + #index + #pageNumber")
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

            }
            case 2: {

            }
            case 3: {

            }
            case 4: {
//                ids = filters.getStates().stream()
//                    .filter(state -> state.isChecked())
//                    .map(state -> state.getId())
//                    .collect(Collectors.toList());
//                if (ids.size() > 0) {
//                    result.put("list", this.stateRepository.findByOrgansIds(ids, pageable).getContent());
//                    result.put("totalRecords", this.stateRepository.findByOrgansIds(ids, pageable).getTotalElements());
//                } else {
//                    result.put("list", this.stateRepository.findAllOrgansTrials(pageable).getContent());
//                    result.put("totalRecords", this.stateRepository.findAllOrgansTrials(pageable).getTotalElements());
//
//                }
//                return result;

            }
            case 5: {

            }
            case 6: {

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
        Map<String, Object> filters = new HashMap<>();
        filters.put("organs", organs);
        filters.put("states", states);
        return filters;

    }

    @Scheduled(fixedRate = 86400000)
    @CacheEvict(value = {"clinicalTrialsCache","FilterListCache","OrgansByFamily,OrgansByFamilyList"}, allEntries = true)
    public void clearClinicalTrialsCache() {
    }

}
