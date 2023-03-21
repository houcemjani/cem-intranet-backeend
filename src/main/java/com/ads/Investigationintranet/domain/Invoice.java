

package com.ads.Investigationintranet.domain;


import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.domain.inclusion.calendar.visit.VisitAct;
import com.ads.Investigationintranet.domain.invoice.InvoiceState;
import com.ads.Investigationintranet.domain.invoice.StaticCounterPart;
import com.ads.Investigationintranet.domain.invoice.StaticFixedCost;
import com.ads.Investigationintranet.domain.invoice.StaticVisitAct;
import com.ads.Investigationintranet.domain.provider.FinancialEntity;
import com.ads.Investigationintranet.domain.trial.TrialCounterPart;
import com.ads.Investigationintranet.domain.trial.TrialFixedCost;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.dozer.Mapping;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_invoices")
@Component
public class Invoice  {



    @Column(name = "number")
    public String number;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Temporal(TemporalType.DATE)
    @Column(name = "issueDate")
    private Calendar issueDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "validationDate")
    private Calendar validationDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "despatchDate")
    private Calendar despatchDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "paymentDate")
    private Calendar paymentDate;

    @Column(name = "issueYear")
    private int issueYear;

    @Column(name = "validationYear")
    private int validationYear;

    @Column(name = "despatchYear")
    private int despatchYear;

    @Column(name = "paymentYear")
    private int paymentYear;
    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "stateHhhid")
    private InvoiceState state;

    @Column(name = "address")
    private String address;
    @Column(name = "referencePromoter")
    private String referencePromoter;
    @Column(name = "centerNumber")
    private String centerNumber;
    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_invoices_2_visit_acts",
            joinColumns = {@JoinColumn(name = "invoiceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "visitActHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    @Mapping("actDescriptions.visitActs")
    private Collection<VisitAct> visitActs = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_invoices_2_trial_fixed_costs",
            joinColumns = {@JoinColumn(name = "invoiceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "trialFixedCostHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TrialFixedCost> fixedCosts = new ArrayList<>();

    @ManyToMany(cascade = CascadeType.DETACH)
    @JoinTable(name = "ig_invoices_2_trial_counter_parts",
            joinColumns = {@JoinColumn(name = "invoiceHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "trialCounterPartHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<TrialCounterPart> counterParts = new ArrayList<>();

    @OneToMany(mappedBy = "invoice", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OrderBy("hhhId ASC")
    private List<StaticVisitAct> staticVisitActs;

    @OneToMany(mappedBy = "invoice", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OrderBy("hhhId ASC")
    private List<StaticFixedCost> staticFixedCosts;

    @OneToMany(mappedBy = "invoice", orphanRemoval = true, cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @OrderBy("hhhId ASC")
    private List<StaticCounterPart> staticCounterParts;

    @Column(name = "currencyCode")
    @Mapping("moneyAmountTotal.currencyCode")
    private String currencyCode;

    @Column(name = "amountTotal", nullable = false, scale = 2, precision = 10)
    private BigDecimal amountTotal = BigDecimal.valueOf(0.0);

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;

    @Column(name = "manualState")
    @JsonProperty
    private Boolean manualState;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId")
    private Trial trial;

    @Column(name = "managementFeesPercentage")
    private Double managementFeesPercentage;

    @Transient
    private String trialName;

    @Transient
    private Long trialHhhId;

    private String visitsNames;

    private String inclusionsInternalIdentifiers;

    @ManyToOne()
    @JoinColumn(name = "financialEntityHhhId")
    private FinancialEntity financialEntity;

    @Transient
    private Long providerHhhId;

    @Transient
    private Long financialEntityHhhId;

    @Transient
    private String trialPrincipalInvestigator;

    @Column
    private BigDecimal manualStaticInvoiceTotalAmount;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceCreator", referencedColumnName = "hhhId")
    private User invoiceCreator;

    @Transient
    private Long croHhhId;

}
