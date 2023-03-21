package com.ads.Investigationintranet.domain.uploads;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;


@Entity

@Table(name = "InclusionManyToManyLiaisons")
public class InclusionManyToManyLiaisons implements Serializable {

    private static final long serialVersionUID = 47591889142809301L;

    @Id
    @Column(name = "inclusionId")
    private Long inclusionId;

    @Column(name = "organFamilies")
    private String organFamilies;

    @Column(name = "organs")
    private String organs;

    public Long getInclusionId() {
        return inclusionId;
    }

    public void setInclusionId(Long inclusionId) {
        this.inclusionId = inclusionId;
    }

    public String getOrganFamilies() {
        return organFamilies;
    }

    public void setOrganFamilies(String organFamilies) {
        this.organFamilies = organFamilies;
    }

    public String getOrgans() {
        return organs;
    }

    public void setOrgans(String organs) {
        this.organs = organs;
    }
}

