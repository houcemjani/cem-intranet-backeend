package com.ads.Investigationintranet.domain.report;//
//package com.ads.Investigationintranet.domain.report;
//
//import com.ads.Investigationintranet.web.dto.establishment.EstablishmentDepartmentPerYear;
//import com.ads.Investigationintranet.web.dto.statistics.PatientPerYear;
//import org.joda.time.LocalDate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component("reportsRateToActiveInpatients")
//public class ReportsRateToActiveInpatients {
//    private List<PatientPerYear> includedPatientPerYear;
//    private List<PatientPerYear> screenedPatientPerYear;
//    private List<EstablishmentDepartmentPerYear> establishmentDepartmentPerYear;
//    private Map<LocalDate, Integer> includedPatientPerYearMap;
//    private Map<LocalDate, Integer> screenedPatientPerYearMap;
//    private Map<LocalDate, Integer> establishmentDepartmentPerYearMap;
//    private String establishmentName;
//
//    public List<PatientPerYear> getIncludedPatientPerYear() {
//        return includedPatientPerYear;
//    }
//
//    public void setIncludedPatientPerYear(List<PatientPerYear> includedPatientPerYear) {
//        this.includedPatientPerYear = includedPatientPerYear;
//    }
//
//    public List<PatientPerYear> getScreenedPatientPerYear() {
//        return screenedPatientPerYear;
//    }
//
//    public void setScreenedPatientPerYear(List<PatientPerYear> screenedPatientPerYear) {
//        this.screenedPatientPerYear = screenedPatientPerYear;
//    }
//
//    public List<EstablishmentDepartmentPerYear> getEstablishmentDepartmentPerYear() {
//        return establishmentDepartmentPerYear;
//    }
//
//    public void setEstablishmentDepartmentPerYear(List<EstablishmentDepartmentPerYear> establishmentDepartmentPerYear) {
//        this.establishmentDepartmentPerYear = establishmentDepartmentPerYear;
//    }
//
//    public String getEstablishmentName() {
//        return establishmentName;
//    }
//
//    public void setEstablishmentName(String establishmentName) {
//        this.establishmentName = establishmentName;
//    }
//
//    public Map<LocalDate, Integer> getIncludedPatientPerYearMap() {
//        return includedPatientPerYearMap;
//    }
//
//    public void setIncludedPatientPerYearMap(Map<LocalDate, Integer> includedPatientPerYearMap) {
//        this.includedPatientPerYearMap = includedPatientPerYearMap;
//    }
//
//    public Map<LocalDate, Integer> getScreenedPatientPerYearMap() {
//        return screenedPatientPerYearMap;
//    }
//
//    public void setScreenedPatientPerYearMap(Map<LocalDate, Integer> screenedPatientPerYearMap) {
//        this.screenedPatientPerYearMap = screenedPatientPerYearMap;
//    }
//
//    public Map<LocalDate, Integer> getEstablishmentDepartmentPerYearMap() {
//        return establishmentDepartmentPerYearMap;
//    }
//
//    public void setEstablishmentDepartmentPerYearMap(Map<LocalDate, Integer> establishmentDepartmentPerYearMap) {
//        this.establishmentDepartmentPerYearMap = establishmentDepartmentPerYearMap;
//    }
//}
