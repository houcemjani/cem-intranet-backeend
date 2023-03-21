package com.ads.Investigationintranet.domain.report;//package com.ads.Investigationintranet.domain.report;
//
//
//import com.ads.Investigationintranet.entity.Organ;
//import com.ads.Investigationintranet.entity.OrganFamily;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component("reportsInclusionsByTrial")
//public class ReportsInclusionsByTrial {
//
//
//    private String trial ;
//    private List<String> organes ;
//    private List<String> OrganFamilies ;
//    private List<String> inclusionsPerTrialInCurrentYear ;
//    private List<String> inclusionsPerYear ;
//    private String total ;
//    private  Long numberPatientsPlanned ;
//    private  int numberInclusionsInScreeningFailure ;
//    private String actualProductionLaunchDate ;
//    private String trialEndDate ;
//    private Map<String, List<OrganFamily>> organFamiliesPerTrialMap;
//    private Map<String, List<Organ>> organsPerTrialMap;
//    private Map<String, List<String>> inclusionsPerTrialInCurrentYearMap;
//    private Map<String, List<String>> inclusionsByTrialAndInclusionYearMap;
//    private Map<String, String> numberInclusionsInScreeningFailureMap;
//    private Map<String, String> totalInclusionsMap;
//    private Map<String, String> numberPatientsPlannedMap;
//    private Map<String, String> actualProductionLaunchDateMap;
//    private Map<String, String> trialEndDateMap;
//
//    public String getTrial() {
//        return trial;
//    }
//
//    public void setTrial(String trial) {
//        this.trial = trial;
//    }
//
//    public List<String> getOrganes() {
//        return organes;
//    }
//
//    public void setOrganes(List<String> organes) {
//        this.organes = organes;
//    }
//
//    public List<String> getInclusionsPerTrialInCurrentYear() {
//        return inclusionsPerTrialInCurrentYear;
//    }
//
//    public void setInclusionsPerTrialInCurrentYear(List<String> inclusionsPerTrialInCurrentYear) {
//        this.inclusionsPerTrialInCurrentYear = inclusionsPerTrialInCurrentYear;
//    }
//
//    public List<String> getInclusionsPerYear() {
//        return inclusionsPerYear;
//    }
//
//    public void setInclusionsPerYear(List<String> inclusionsPreviousYear) {
//        this.inclusionsPerYear = inclusionsPreviousYear;
//    }
//
//    public String getTotal() {
//        return total;
//    }
//
//    public void setTotal(String total) {
//        this.total = total;
//    }
//
//    public Long getNumberPatientsPlanned() {
//        return numberPatientsPlanned;
//    }
//
//    public void setNumberPatientsPlanned(Long numberPatientsPlanned) {
//        this.numberPatientsPlanned = numberPatientsPlanned;
//    }
//
//    public int getNumberInclusionsInScreeningFailure() {
//        return numberInclusionsInScreeningFailure;
//    }
//
//    public void setNumberInclusionsInScreeningFailure(int numberInclusionsInScreeningFailure) {
//        this.numberInclusionsInScreeningFailure = numberInclusionsInScreeningFailure;
//    }
//
//    public String getActualProductionLaunchDate() {
//        return actualProductionLaunchDate;
//    }
//
//    public void setActualProductionLaunchDate(String actualProductionLaunchDate) {
//        this.actualProductionLaunchDate = actualProductionLaunchDate;
//    }
//
//    public String getTrialEndDate() {
//        return trialEndDate;
//    }
//
//    public void setTrialEndDate(String trialEndDate) {
//        this.trialEndDate = trialEndDate;
//    }
//
//    public List<String> getOrganFamilies() {
//        return OrganFamilies;
//    }
//
//    public void setOrganFamilies(List<String> organFamilies) {
//        OrganFamilies = organFamilies;
//    }
//
//
//    public Map<String, List<OrganFamily>> getOrganFamiliesPerTrialMap() {
//        return organFamiliesPerTrialMap;
//    }
//
//    public void setOrganFamiliesPerTrialMap(Map<String, List<OrganFamily>> organFamiliesPerTrialMap) {
//        this.organFamiliesPerTrialMap = organFamiliesPerTrialMap;
//    }
//
//    public Map<String, List<Organ>> getOrgansPerTrialMap() {
//        return organsPerTrialMap;
//    }
//
//    public void setOrgansPerTrialMap(Map<String, List<Organ>> organsPerTrialMap) {
//        this.organsPerTrialMap = organsPerTrialMap;
//    }
//
//    public Map<String, List<String>> getInclusionsPerTrialInCurrentYearMap() {
//        return inclusionsPerTrialInCurrentYearMap;
//    }
//
//    public void setInclusionsPerTrialInCurrentYearMap(Map<String, List<String>> inclusionsPerTrialInCurrentYearMap) {
//        this.inclusionsPerTrialInCurrentYearMap = inclusionsPerTrialInCurrentYearMap;
//    }
//
//    public Map<String, List<String>> getInclusionsByTrialAndInclusionYearMap() {
//        return inclusionsByTrialAndInclusionYearMap;
//    }
//
//    public void setInclusionsByTrialAndInclusionYearMap(Map<String, List<String>> inclusionsByTrialAndInclusionYearMap) {
//        this.inclusionsByTrialAndInclusionYearMap = inclusionsByTrialAndInclusionYearMap;
//    }
//
//    public Map<String, String> getNumberInclusionsInScreeningFailureMap() {
//        return numberInclusionsInScreeningFailureMap;
//    }
//
//    public void setNumberInclusionsInScreeningFailureMap(Map<String, String> numberInclusionsInScreeningFailureMap) {
//        this.numberInclusionsInScreeningFailureMap = numberInclusionsInScreeningFailureMap;
//    }
//
//    public Map<String, String> getTotalInclusionsMap() {
//        return totalInclusionsMap;
//    }
//
//    public void setTotalInclusionsMap(Map<String, String> totalInclusionsMap) {
//        this.totalInclusionsMap = totalInclusionsMap;
//    }
//
//    public Map<String, String> getNumberPatientsPlannedMap() {
//        return numberPatientsPlannedMap;
//    }
//
//    public void setNumberPatientsPlannedMap(Map<String, String> numberPatientsPlannedMap) {
//        this.numberPatientsPlannedMap = numberPatientsPlannedMap;
//    }
//
//    public Map<String, String> getActualProductionLaunchDateMap() {
//        return actualProductionLaunchDateMap;
//    }
//
//    public void setActualProductionLaunchDateMap(Map<String, String> actualProductionLaunchDateMap) {
//        this.actualProductionLaunchDateMap = actualProductionLaunchDateMap;
//    }
//
//    public Map<String, String> getTrialEndDateMap() {
//        return trialEndDateMap;
//    }
//
//    public void setTrialEndDateMap(Map<String, String> trialEndDateMap) {
//        this.trialEndDateMap = trialEndDateMap;
//    }
//}
