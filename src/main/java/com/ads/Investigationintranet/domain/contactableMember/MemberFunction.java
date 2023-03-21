package com.ads.Investigationintranet.domain.contactableMember;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity(name = "MemberFunction")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_member_function")
public class MemberFunction  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "code")
    @JsonProperty
    private String code;

    @Column(name = "nameFr")
    @JsonProperty
    private String nameFr;

    @Column(name = "nameEn")
    @JsonProperty
    private String nameEn;

}
