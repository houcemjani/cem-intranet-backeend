package com.ads.Investigationintranet.domain;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "InvoiceManyToManyLiaisons")
public class InvoiceManyToManyLiaisons {

    @Id
    @Column(name = "invoiceHhhId")
    private long invoiceHhhId;

    @Column(name = "inclusionsInternalIdentifiers")
    private String inclusionsInternalIdentifiers;

    @Column(name = "visitsNames")
    private String visitsNames;

}
