package com.ads.Investigationintranet.domain.invoice;

import com.ads.Investigationintranet.domain.Invoice;
import com.ads.Investigationintranet.domain.inclusion.calendar.visit.VisitAct;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_static_invoice_fixed_cost")
public class StaticFixedCost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "localIdentifier")
    @JsonProperty
    private String localIdentifier;

    @Column(name = "promoter")
    @JsonProperty
    private String promoter;

    @Column(name = "numberProtocol")
    @JsonProperty
    private String numberProtocol;

    @Column(name = "category")
    @JsonProperty
    private String category;

    @Column(name = "internalAccountNumber")
    @JsonProperty
    private String internalAccountNumber;

    @Column(name = "description")
    @JsonProperty
    private String description;

    @Column(name = "pricePerUnit", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal unitPrice = BigDecimal.valueOf(0.0);
    ;

    @Column(name = "numberOfUnits", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal unitNumber = BigDecimal.valueOf(1.0);

    @Column(name = "priceTotal", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal total = BigDecimal.valueOf(0.0);
    ;

    @Column(name = "isInvoiceable")
    @JsonProperty
    private boolean invoiceable;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "versionHhhId")
    @JsonIgnore
    @EntityRef
    private InvoiceHistory invoiceHistory;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceHhhId")
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "visitActHhhId")
    private VisitAct visitAct;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @Column
    private String type;

    @Column
    private String date;

    @Column
    private String visitName;

    @Column
    private String inclusionNumber;

    @Column
    private String actVisit;

    @Column
    private String patientInitials;


}
