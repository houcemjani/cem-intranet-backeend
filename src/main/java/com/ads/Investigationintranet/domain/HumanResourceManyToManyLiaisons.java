package com.ads.Investigationintranet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "HumanResourceManyToManyLiaisons")
public class HumanResourceManyToManyLiaisons  {

    private static final long serialVersionUID = 47591889142809301L;

    @Id
    @Column(name = "humanResourceId")
    private Long humanResourceId;

    @Column(name = "responsibilities")
    private String responsibilities;

    @Column(name = "responsibilitiesHhhId")
    private String responsibilitiesHhhId;

    @Column(name = "specialitiesHhhId")
    private String specialitiesHhhId;

    @Column(name = "servicesHhhId")
    private String servicesHhhId;

    @Column(name = "committeesHhhId")
    private String committeesHhhId;

    @Column(name = "departmentsHhhId")
    private String departmentsHhhId;


}
