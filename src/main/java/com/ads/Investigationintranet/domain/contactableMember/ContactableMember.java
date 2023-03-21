package com.ads.Investigationintranet.domain.contactableMember;

import com.ads.Investigationintranet.domain.Establishment;
import com.ads.Investigationintranet.domain.Provider;
import com.ads.Investigationintranet.domain.Site;
import com.ads.Investigationintranet.domain.contact.ContactSet;
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
@Table(name = "ig_contactable_member")
public class ContactableMember  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "memberFunctionHhhid")
    @JsonProperty
    private MemberFunction memberFunction;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "providerHhhid")
    @JsonIgnore
    private Provider provider;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentHhhid")
    @JsonIgnore
    private Establishment establishment;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "siteHhhid")
    @JsonIgnore
    private Site site;

    @OneToOne(cascade = {CascadeType.ALL}, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "contactSetHhhId")
    @JsonIgnore
    private ContactSet contactSet;

    @Column(name = "memberFunctionOtherValue")
    @JsonProperty
    private String memberFunctionOtherValue;

}
