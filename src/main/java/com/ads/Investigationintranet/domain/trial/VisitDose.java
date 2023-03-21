package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.domain.inclusion.calendar.Visit;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class VisitDose {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    private String dose;

    private String date;

    @ManyToOne
    private Visit visit;

    @ManyToOne
    private User owner;

}
