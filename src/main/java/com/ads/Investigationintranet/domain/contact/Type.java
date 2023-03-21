package com.ads.Investigationintranet.domain.contact;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "ig_contacts_types")
@Table(name = "ig_contacts_types")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Type  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "name")
    private String name;

}
