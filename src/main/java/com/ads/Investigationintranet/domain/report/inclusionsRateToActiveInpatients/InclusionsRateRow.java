package com.ads.Investigationintranet.domain.report.inclusionsRateToActiveInpatients;//
//
//package com.ads.Investigationintranet.domain.report.inclusionsRateToActiveInpatients;
//
//import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
//
//public class InclusionsRateRow implements Comparable<InclusionsRateRow> {
//    private int year;
//    private long numberActiveInpatients;
//    private long numberInclusionsExceptScreeningFailures;
//    private double rateInclusionsExceptScreeningFailures;
//    private EstablishmentDepartment establishmentDepartment;
//
//    public InclusionsRateRow() {
//    }
//
//    public int getYear() {
//        return year;
//    }
//
//    public void setYear(int year) {
//        this.year = year;
//    }
//
//    public long getNumberActiveInpatients() {
//        return numberActiveInpatients;
//    }
//
//    public void setNumberActiveInpatients(long numberActiveInpatients) {
//        this.numberActiveInpatients = numberActiveInpatients;
//    }
//
//    public long getNumberInclusionsExceptScreeningFailures() {
//        return numberInclusionsExceptScreeningFailures;
//    }
//
//    public void setNumberInclusionsExceptScreeningFailures(long numberInclusionsExceptScreeningFailures) {
//        this.numberInclusionsExceptScreeningFailures = numberInclusionsExceptScreeningFailures;
//    }
//
//    public double getRateInclusionsExceptScreeningFailures() {
//        return rateInclusionsExceptScreeningFailures;
//    }
//
//    public void setRateInclusionsExceptScreeningFailures(double rateInclusionsExceptScreeningFailures) {
//        this.rateInclusionsExceptScreeningFailures = rateInclusionsExceptScreeningFailures;
//    }
//
//    public EstablishmentDepartment getEstablishmentDepartment() {
//        return establishmentDepartment;
//    }
//
//    public void setEstablishmentDepartment(EstablishmentDepartment establishmentDepartment) {
//        this.establishmentDepartment = establishmentDepartment;
//    }
//
//    public String getFullName() {
//        String fullName = "";
//        if (this.establishmentDepartment != null)
//            fullName = fullName + this.establishmentDepartment.getFullName();
//        return (fullName.isEmpty() ? ("" + this.year) : ( fullName + " " + year));
//    }
//
//    @Override
//    public int compareTo(InclusionsRateRow o) {
//        return (o.getFullName()).compareTo(this.getFullName());
//    }
//}
