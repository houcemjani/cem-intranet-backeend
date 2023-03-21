

package com.ads.Investigationintranet.domain;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.joda.time.LocalDate;
import org.joda.time.chrono.ISOChronology;

import javax.persistence.*;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

@Entity
@Table(name = "ig_patients")
public class ReportsPatient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;


    @Column(name = "internalIdentifier", unique = true)
    private String internalIdentifier;

    @Temporal(TemporalType.DATE)
    @Column(name = "birthDate")
    private Calendar birthDate;

    @OneToMany(mappedBy = "patient", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ReportsInclusion> trialInclusions;


    public long getHhhId() {
        return hhhId;
    }

    public void setHhhId(long hhhId) {
        this.hhhId = hhhId;
    }

    public String getInternalIdentifier() {
        return internalIdentifier;
    }

    public void setInternalIdentifier(String internalIdentifier) {
        this.internalIdentifier = internalIdentifier;
    }

    public LocalDate getBirthDate() {
        return this.birthDate == null ? null : new LocalDate(this.birthDate, ISOChronology.getInstance());
    }

    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = (birthDate == null) ? null : birthDate.toDateTimeAtStartOfDay().toCalendar(Locale.getDefault());
    }

    public List<ReportsInclusion> getTrialInclusions() {
        return trialInclusions;
    }

    public void setTrialInclusions(List<ReportsInclusion> trialInclusions) {
        this.trialInclusions = trialInclusions;
    }


}
