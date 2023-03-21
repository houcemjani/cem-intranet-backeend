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
@Table(name = "ig_static_invoice_visit_act")
public class StaticVisitAct {

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

    @Column(name = "site")
    @JsonProperty
    private String site;

    @Column(name = "inclusionNumber")
    @JsonProperty
    private String inclusionNumber;

    @Column(name = "patientNumber")
    @JsonProperty
    private String patientNumber;

    @Column(name = "patientInitials")
    @JsonProperty
    private String patientInitials;

    @Column(name = "visitDate")
    @JsonProperty
    private String visitDate;

    @Column(name = "actVisit")
    @JsonProperty
    private String actVisit;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "visitActHhhId")
    private VisitAct visitAct ;

    @Column(name = "actCategory")
    @JsonProperty
    private String actCategory;

    @Column(name = "internalAccountNumber")
    @JsonProperty
    private String internalAccountNumber;

    @Column(name = "act")
    @JsonProperty
    private String act;

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

    @Column(name = "code")
    @JsonProperty
    private String code;

    @Column
    private String contractType;

    @Column
    private String type;

    @Column(name = "onPrescription")
    @JsonProperty
    private boolean onPrescription;

    @Column(name = "externalFromCentre")
    @JsonProperty
    private boolean externalFromCentre;

    @Column
    private String firstSegment;

    @Column
    private String secondSegment;

    @Column
    private String date;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "versionHhhId")
    @JsonIgnore
    @EntityRef
    private InvoiceHistory invoiceHistory;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "invoiceHhhId")
    private Invoice invoice;

}
