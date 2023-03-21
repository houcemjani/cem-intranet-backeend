package com.ads.Investigationintranet.service;

import com.ads.Investigationintranet.dto.OrganDto;
import com.ads.Investigationintranet.dto.OrganFamilyDto;
import com.ads.Investigationintranet.dto.TrialFilterDto;

import java.util.List;
import java.util.Map;

public interface TrialService {

    Map<String, Object> getFilterList();

    Map<String, Object> getClinicalTrials(TrialFilterDto filters, Integer index, int pageSize , int pageNumber);




}
