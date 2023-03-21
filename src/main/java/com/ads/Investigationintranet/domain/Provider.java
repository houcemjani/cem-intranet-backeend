package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.contactableMember.ContactableMember;
import com.ads.Investigationintranet.domain.provider.FinancialEntity;
import com.ads.Investigationintranet.domain.provider.ProviderType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_providers")
public class Provider  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name", unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.DETACH)
    @JoinColumn(name = "providerTypeHhhId", referencedColumnName = "hhhId")
    @JsonProperty
    private ProviderType providerType;

    @Column(name = "providerTypeOtherValue")
    @JsonIgnore
    private String providerTypeOtherValue;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "promoterTypeHhhid")
    @JsonProperty
    private PromoterType promoterType;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    @JsonIgnore
    @Fetch(value = FetchMode.SUBSELECT)
    private List<ContactableMember> contactableMembers = new ArrayList<>();

    @Column
    String financialManageName;

    @Column
    String precisionPostalInvoicingAddress;

    @Column
    String postalInvoicingAddressNumber;

    @Column
    String postalInvoicingAddressStreet;

    @Column
    String postalInvoicingAddressCode;

    @Column
    String postalInvoicingAddressCity;

    @Column
    String postalInvoicingAddressCedex;

    @Column
    String postalInvoicingAddressCountry;

    @Column
    String postalInvoiceSendingAddress;

    @Column
    String mail;

    @Column
    String phone;

    @Column
    String promoterAccountantNumber;

    @Column
    String tva;

    @Column
    String tvaIntraCommunity;

    @OneToMany(mappedBy = "provider", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<FinancialEntity> financialEntities = new ArrayList<>();

}
