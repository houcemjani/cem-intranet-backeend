package com.ads.Investigationintranet.domain.invoice;

import com.ads.Investigationintranet.domain.Invoice;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_static_invoice_history")
public class InvoiceHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "modificationDate", nullable = false, updatable = false)
    @JsonProperty
    @CreationTimestamp
    private LocalDateTime modificationDate;

    @Column(name = "modifiedBy", nullable = false, updatable = false)
    @JsonProperty
    private String userName;

    @Column(name = "modificationType", nullable = false, updatable = false)
    @JsonProperty
    private String modificationType;

    @OneToMany(mappedBy = "invoiceHistory", orphanRemoval = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    private List<StaticVisitAct> staticVisitActs;

    @OneToMany(mappedBy = "invoiceHistory", orphanRemoval = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    private List<StaticFixedCost> staticFixedCosts;

    @OneToMany(mappedBy = "invoiceHistory", orphanRemoval = true, cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
    private List<StaticCounterPart> staticCounterParts;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "invoiceHhhId")
    private Invoice invoice;

    @Column
    private BigDecimal staticInvoiceTotalAmount;


}
