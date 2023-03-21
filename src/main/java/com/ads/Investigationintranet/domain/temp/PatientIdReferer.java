package com.ads.Investigationintranet.domain.temp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ig_patient_id_referer")
public class PatientIdReferer  {

    @Id
    @Column(name = "hhhId")
    private Long hhhId;

    public PatientIdReferer() {}

    public PatientIdReferer(Long id) {
        setHhhId(id);
    }

    public Long getHhhId() {
        return hhhId;
    }

    public void setHhhId(Long hhhId) {
        this.hhhId = hhhId;
    }
}
