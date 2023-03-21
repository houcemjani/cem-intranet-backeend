package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.Invoice;
import com.ads.Investigationintranet.domain.trial.theoreticalInvoice.State;
import com.ads.Investigationintranet.domain.trial.version.EntityRef;
import com.ads.Investigationintranet.entity.Trial;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Calendar;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_theoretical_invoice")
public class TheoreticalInvoice  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @Column(name = "theoreticalAmount", nullable = false, scale = 2, precision = 10)
    @JsonProperty
    private BigDecimal theoreticalAmount = BigDecimal.valueOf(0.0);

    @Column(name = "currencyCode")
    @JsonProperty
    private String currencyCode;

    @Temporal(TemporalType.DATE)
    @Column(name = "theoreticalIssueDate")
    private Calendar theoreticalIssueDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "trialHhhId", referencedColumnName = "hhhId")
    @JsonIgnore
    @EntityRef
    private Trial trial;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    
    private Invoice invoice;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "stateHhhId")
    @JsonProperty
    private State state;

}
