package com.ads.Investigationintranet.domain.uploads;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "ig_imports")
public class Import {

    // Attributes

    @Id
    @Column(name = "hhhId")
    @JsonProperty
    private Long hhhId;

    @Basic
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "creationDate")
    @JsonProperty
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss")
    private Date creationDate;


    // Constructor

    public Import() {
    }

    public Import(Long hhhId) {
        setHhhId(hhhId);
    }


    // Getters and setters

    public Long getHhhId() {
        return hhhId;
    }

    public void setHhhId(Long hhhId) {
        this.hhhId = hhhId;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

}
