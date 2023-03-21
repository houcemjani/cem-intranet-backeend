package com.ads.Investigationintranet.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "ig_hidden_fields")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HiddenField  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "name")
    private String name;

    @Column(name = "code")
    private String code;

    @Column(name = "property_flag")
    private String propertyFlag;


}
