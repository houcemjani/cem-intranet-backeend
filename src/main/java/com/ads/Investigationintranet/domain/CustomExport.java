package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "ig_custom_export")
public class CustomExport {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @OneToOne(mappedBy = "customExport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    @EntityRef
    private User user;

    @OneToOne(mappedBy = "customExport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    @EntityRef
    private TrialExportFilter trialExportFilter;

    @OneToOne(mappedBy = "customExport", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JsonIgnore
    @EntityRef
    private PatientExportFilter patientExportFilter;

    @Column(name = "trialExportFields")
    @JsonProperty
    private String trialExportFields;

    @Column(name = "patientExportFields")
    @JsonProperty
    private String patientExportFields;

}
