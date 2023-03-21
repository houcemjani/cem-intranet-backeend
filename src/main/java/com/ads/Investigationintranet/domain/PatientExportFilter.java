package com.ads.Investigationintranet.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_patient_export_filter")
public class PatientExportFilter  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "establishment")
    @JsonProperty
    private long establishment;

    @Column(name = "site")
    @JsonProperty
    private long site;

    @Column(name = "phase")
    @JsonProperty
    private long phase;

    @Column(name = "state")
    @JsonProperty
    private long state;

    @Column(name = "sex")
    @JsonProperty
    private String sex;

    @Column(name = "lifeState")
    @JsonProperty
    private long lifeState;

    @Column(name = "addressedByExternalDoctor")
    @JsonProperty
    private long addressedByExternalDoctor = -1;

    @OneToOne(cascade = {CascadeType.PERSIST}, fetch = FetchType.EAGER)
    @JoinColumn(name = "customExportHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    private CustomExport customExport;

}
