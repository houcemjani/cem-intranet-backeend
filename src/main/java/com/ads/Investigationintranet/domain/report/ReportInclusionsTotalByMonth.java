package com.ads.Investigationintranet.domain.report;//
//
//package com.ads.Investigationintranet.domain.report;
//
//
//import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
//import com.ads.Investigationintranet.web.dto.home.InclusionEstablishmentDepartment;
//import com.ads.Investigationintranet.web.dto.statistics.RateInclusionPerTrial;
//import com.ads.Investigationintranet.web.dto.trial.InclusionDate;
//import org.joda.time.LocalDate;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//import java.util.Map;
//
//@Component("reportInclusionsTotalByMonth")
//public class ReportInclusionsTotalByMonth {
//    private List<InclusionEstablishmentDepartment> inclusionEstablishmentDepartment;
//    private List<RateInclusionPerTrial> rateInclusionPerTrial;
//    private List<InclusionDate> inclusionsDate;
//    private Long inclusionsNumber;
//    private Map<EstablishmentDepartment, Long> inclusionEstablishmentDepartmentMap;
//    private Map<LocalDate, Long> inclusionDateMap;
//
//
//    public List<InclusionEstablishmentDepartment> getInclusionEstablishmentDepartment() {
//        return inclusionEstablishmentDepartment;
//    }
//
//    public void setInclusionEstablishmentDepartment(List<InclusionEstablishmentDepartment> inclusionEstablishmentDepartment) {
//        this.inclusionEstablishmentDepartment = inclusionEstablishmentDepartment;
//    }
//
//    public List<RateInclusionPerTrial> getRateInclusionPerTrial() {
//        return rateInclusionPerTrial;
//    }
//
//    public void setRateInclusionPerTrial(List<RateInclusionPerTrial> rateInclusionPerTrial) {
//        this.rateInclusionPerTrial = rateInclusionPerTrial;
//    }
//
//    public List<InclusionDate> getInclusionsDate() {
//        return inclusionsDate;
//    }
//
//    public void setInclusionsDate(List<InclusionDate> inclusionsDate) {
//        this.inclusionsDate = inclusionsDate;
//    }
//
//    public Long getInclusionsNumber() {
//        return inclusionsNumber;
//    }
//
//    public void setInclusionsNumber(Long inclusionsNumber) {
//        this.inclusionsNumber = inclusionsNumber;
//    }
//
//    public Map<EstablishmentDepartment, Long> getInclusionEstablishmentDepartmentMap() {
//        return inclusionEstablishmentDepartmentMap;
//    }
//
//    public void setInclusionEstablishmentDepartmentMap(Map<EstablishmentDepartment, Long> inclusionEstablishmentDepartmentMap) {
//        this.inclusionEstablishmentDepartmentMap = inclusionEstablishmentDepartmentMap;
//    }
//
//    public Map<LocalDate, Long> getInclusionDateMap() {
//        return inclusionDateMap;
//    }
//
//    public void setInclusionDateMap(Map<LocalDate, Long> inclusionDateMap) {
//        this.inclusionDateMap = inclusionDateMap;
//    }
//}
