package com.ads.Investigationintranet.domain;//
//
//package com.ads.Investigationintranet.domain;
//
//import com.ads.Investigationintranet.web.dto.home.InclusionsPerMonth;
//import com.ads.Investigationintranet.web.dto.trial.InclusionPerState;
//import com.ads.Investigationintranet.web.dto.trial.TrialCountState;
//import org.springframework.stereotype.Component;
//
//import java.util.List;
//
//@Component("clinicalResearchActivities")
//public class ClinicalResearchActivity {
//
//    private List<InclusionPerState> inclusionStates;
//    private List<InclusionPerState> inclusionsProgress;
//    private List<TrialCountState> TrialStates;
//    private List<InclusionsPerMonth> inclusionsGoal;
//    private long inclusionsTotal;
//    private long patientTotal;
//    private long trialsTotal;
//    private Long totalTheoreticalNumberOfInclusions;
//
//    public Long getTotalTheoreticalNumberOfInclusions() {
//        return totalTheoreticalNumberOfInclusions;
//    }
//
//    public void setTotalTheoreticalNumberOfInclusions(Long totalTheoreticalNumberOfInclusions) {
//        this.totalTheoreticalNumberOfInclusions = totalTheoreticalNumberOfInclusions;
//    }
//
//    public long getInclusionsTotal() {
//        return inclusionsTotal;
//    }
//
//    public void setInclusionsTotal(long inclusionsTotal) {
//        this.inclusionsTotal = inclusionsTotal;
//    }
//
//    public List<InclusionPerState> getInclusionsProgressMap() {
//        return inclusionsProgress;
//    }
//
//    public void setInclusionsProgress(List<InclusionPerState> inclusionsProgress) {
//        this.inclusionsProgress = inclusionsProgress;
//    }
//
//    public List<InclusionPerState> getInclusionStates() {
//        return inclusionStates;
//    }
//
//    public void setInclusionStates(List<InclusionPerState> inclusionStates) {
//        this.inclusionStates = inclusionStates;
//    }
//
//    public List<TrialCountState> getTrialStates() {
//        return TrialStates;
//    }
//
//    public void setTrialStates(List<TrialCountState> trialStates) {
//        TrialStates = trialStates;
//    }
//
//    public long getPatientTotal() {
//        return patientTotal;
//    }
//
//    public void setPatientTotal(long patientTotal) {
//        this.patientTotal = patientTotal;
//    }
//
//    public long getTrialsTotal() {
//        return trialsTotal;
//    }
//
//    public void setTrialsTotal(long trialsTotal) {
//        this.trialsTotal = trialsTotal;
//    }
//
//    public List<InclusionsPerMonth> getInclusionsGoal() {
//        return inclusionsGoal;
//    }
//
//    public void setInclusionsGoal(List<InclusionsPerMonth> inclusionsGoal) {
//        this.inclusionsGoal = inclusionsGoal;
//    }
//}
