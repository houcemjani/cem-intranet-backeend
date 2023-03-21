package com.ads.Investigationintranet.domain.provider;

import com.ads.Investigationintranet.domain.Provider;

import javax.persistence.*;

@Entity
@Table(name = "ig_provider_financial_enties")
public class FinancialEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column
    private String financialManageName;

    @Column
    private String precisionPostalInvoicingAddress;

    @Column
    private String postalInvoicingAddressNumber;

    @Column
    private String postalInvoicingAddressStreet;

    @Column
    private String postalInvoicingAddressCode;

    @Column
    private String postalInvoicingAddressCity;

    @Column
    private String postalInvoicingAddressCedex;

    @Column
    private String postalInvoicingAddressCountry;

    @Column
    private String postalInvoiceSendingAddress;

    @Column
    private String mail;

    @Column
    private String phone;

    @Column
    private String promoterAccountantNumber;

    @Column
    private String tva;

    @Column
    private String tvaIntraCommunity;

    @ManyToOne()
    private Provider provider;

    public FinancialEntity() {
    }

    public long getHhhId() {
        return hhhId;
    }

    public void setHhhId(long hhhId) {
        this.hhhId = hhhId;
    }

    public String getFinancialManageName() {
        return financialManageName;
    }

    public void setFinancialManageName(String financialManageName) {
        this.financialManageName = financialManageName;
    }

    public String getPrecisionPostalInvoicingAddress() {
        return precisionPostalInvoicingAddress;
    }

    public void setPrecisionPostalInvoicingAddress(String precisionPostalInvoicingAddress) {
        this.precisionPostalInvoicingAddress = precisionPostalInvoicingAddress;
    }

    public String getPostalInvoicingAddressNumber() {
        return postalInvoicingAddressNumber;
    }

    public void setPostalInvoicingAddressNumber(String postalInvoicingAddressNumber) {
        this.postalInvoicingAddressNumber = postalInvoicingAddressNumber;
    }

    public String getPostalInvoicingAddressStreet() {
        return postalInvoicingAddressStreet;
    }

    public void setPostalInvoicingAddressStreet(String postalInvoicingAddressStreet) {
        this.postalInvoicingAddressStreet = postalInvoicingAddressStreet;
    }

    public String getPostalInvoicingAddressCode() {
        return postalInvoicingAddressCode;
    }

    public void setPostalInvoicingAddressCode(String postalInvoicingAddressCode) {
        this.postalInvoicingAddressCode = postalInvoicingAddressCode;
    }

    public String getPostalInvoicingAddressCity() {
        return postalInvoicingAddressCity;
    }

    public void setPostalInvoicingAddressCity(String postalInvoicingAddressCity) {
        this.postalInvoicingAddressCity = postalInvoicingAddressCity;
    }

    public String getPostalInvoicingAddressCedex() {
        return postalInvoicingAddressCedex;
    }

    public void setPostalInvoicingAddressCedex(String postalInvoicingAddressCedex) {
        this.postalInvoicingAddressCedex = postalInvoicingAddressCedex;
    }

    public String getPostalInvoicingAddressCountry() {
        return postalInvoicingAddressCountry;
    }

    public void setPostalInvoicingAddressCountry(String postalInvoicingAddressCountry) {
        this.postalInvoicingAddressCountry = postalInvoicingAddressCountry;
    }

    public String getPostalInvoiceSendingAddress() {
        return postalInvoiceSendingAddress;
    }

    public void setPostalInvoiceSendingAddress(String postalInvoiceSendingAddress) {
        this.postalInvoiceSendingAddress = postalInvoiceSendingAddress;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPromoterAccountantNumber() {
        return promoterAccountantNumber;
    }

    public void setPromoterAccountantNumber(String promoterAccountantNumber) {
        this.promoterAccountantNumber = promoterAccountantNumber;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getTvaIntraCommunity() {
        return tvaIntraCommunity;
    }

    public void setTvaIntraCommunity(String tvaIntraCommunity) {
        this.tvaIntraCommunity = tvaIntraCommunity;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}
