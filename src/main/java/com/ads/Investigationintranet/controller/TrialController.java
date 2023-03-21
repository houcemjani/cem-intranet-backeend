package com.ads.Investigationintranet.controller;

import com.ads.Investigationintranet.dto.TrialFilterDto;
import com.ads.Investigationintranet.service.TrialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rest")
public class TrialController {
    @Autowired
    private TrialService trialService;
    @PostMapping("/filter/{index}/{pageSize}/{pageNumber}")
    public Map<String, Object> getClinicalTrials(@PathVariable Integer index ,
                                                 @PathVariable int pageSize ,
                                                 @PathVariable  int pageNumber,
                                                 @RequestBody TrialFilterDto filter ){
        return this.trialService.getClinicalTrials(filter, index,pageSize,pageNumber);
    }
    @GetMapping ("/getfilters")
    public Map<String, Object> getFilterList(){
        return this.trialService.getFilterList();
    }




}
