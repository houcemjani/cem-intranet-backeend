package com.ads.Investigationintranet.domain.inclusion;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Calendar;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_bloc_request_dates")
public class BlocFields  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Temporal(TemporalType.DATE)
    @Column(name = "blocRequestDate")
    @JsonProperty
    private Calendar blocRequestDate;

    @Temporal(TemporalType.DATE)
    @Column(name = "dispatchBlockDate")
    @JsonProperty
    private Calendar dispatchBlockDate;

    @Column(name = "result")
    @JsonProperty
    private String result;

    @Temporal(TemporalType.DATE)
    @Column(name = "resultDate")
    @JsonProperty
    private Calendar resultDate;

}

