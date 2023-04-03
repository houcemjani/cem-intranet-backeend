package com.ads.Investigationintranet.service;

import com.ads.Investigationintranet.dto.TrialFilterDto;

import java.util.Map;

public interface TrialService {

    Map<String, Object> getFilterList();

    Map<String, Object> getClinicalTrials(TrialFilterDto filters,int pageSize , int pageNumber);




}
