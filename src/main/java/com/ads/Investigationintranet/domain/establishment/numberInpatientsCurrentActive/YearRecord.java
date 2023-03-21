package com.ads.Investigationintranet.domain.establishment.numberInpatientsCurrentActive;

import com.ads.Investigationintranet.domain.establishment.EstablishmentDepartment;
import com.ads.Investigationintranet.domain.establishment.NumberInpatientsCurrentActive;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_establishments_numberInpatientsCurrentActive_yearRecords",
    uniqueConstraints = @UniqueConstraint(columnNames = {"establishmentDepartmentHhhid", "year"})
)
public class YearRecord  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentDepartmentHhhid")
    private EstablishmentDepartment establishmentDepartment;

    private int year;
    private int value;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "numberInpatientsCurrentActiveHhhId")
    private NumberInpatientsCurrentActive numberInpatientsCurrentActive;

}


