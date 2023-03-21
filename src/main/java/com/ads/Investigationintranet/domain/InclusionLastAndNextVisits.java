

package com.ads.Investigationintranet.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Calendar;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "inclusionLastAndNextVisits")
public class InclusionLastAndNextVisits  {

    private static final long serialVersionUID = 47591889142809301L;

    @Id
    @Column(name = "inclusionHhhId")
    private Long inclusionHhhId;

    @Column(name = "lastVisit")
    private Calendar lastVisit;

    @Column(name = "nextVisit")
    private Calendar nextVisit;

    @Column(name = "nextVisitName")
    private String nextVisitName;

}
