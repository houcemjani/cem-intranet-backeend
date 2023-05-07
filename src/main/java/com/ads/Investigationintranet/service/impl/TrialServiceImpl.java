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

import java.util.Arrays;
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
    if(filters.getFilterIndex()==-1){
        result.put("list", this.trialRepository.findAllTrials(pageable).getContent());
        result.put("totalRecords", this.trialRepository.findAllTrials(pageable).getTotalElements());
        return result;
    }else{
        List<Long> organIds = filters.getOrgans().stream()
                .filter(organ -> organ.isChecked())
                .map(organ -> organ.getId())
                .collect(Collectors.toList());

        List<Long> phaseIds = filters.getPhases().stream()
                .filter(phase -> phase.isChecked())
                .map(phase -> phase.getId())
                .collect(Collectors.toList());

        List<Long> stateIds=filters.getStates().stream()
                .filter(state -> state.isChecked())
                .map(state -> state.getId())
                .collect(Collectors.toList());

        List<Long> metastaticLinesIds=filters.getLines().stream()
                .filter(line -> line.isChecked())
                .map(line -> line.getId())
                .collect(Collectors.toList());

        List<Long> illnessStatesIds=filters.getIllnessStates().stream()
                .filter(illnessStates -> illnessStates.isChecked())
                .map(illnessStates -> illnessStates.getId())
                .collect(Collectors.toList());


        List<Long> organIdsList = (organIds != null && !organIds.isEmpty()) ? organIds : null;
        List<Long> phaseIdsList = (phaseIds != null && !phaseIds.isEmpty()) ? phaseIds : null;
        List<Long> stateIdsList = (stateIds != null && !stateIds.isEmpty()) ? stateIds : Arrays.asList(5L, 6L, 7L);
        List<Long> metastaticLinesIdsList = (metastaticLinesIds != null && !metastaticLinesIds.isEmpty()) ? metastaticLinesIds : null;
        List<Long> illnessStatesIdsList = (illnessStatesIds != null && !illnessStatesIds.isEmpty()) ? illnessStatesIds : null;
        String word=(filters.getWord() != null && !filters.getWord().isEmpty()) ? filters.getWord().trim() : null;

        result.put("list", this.trialRepository.findByCriteria(organIdsList,stateIdsList,phaseIdsList,metastaticLinesIdsList,illnessStatesIdsList,word,pageable).getContent());
        result.put("totalRecords", this.trialRepository.findByCriteria(organIdsList,stateIdsList,phaseIdsList,metastaticLinesIdsList,illnessStatesIdsList,word,pageable).getTotalElements());
        return result;
    }
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
