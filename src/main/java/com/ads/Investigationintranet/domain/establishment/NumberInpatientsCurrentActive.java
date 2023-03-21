package com.ads.Investigationintranet.domain.establishment;

import com.ads.Investigationintranet.domain.Establishment;
import com.ads.Investigationintranet.domain.establishment.numberInpatientsCurrentActive.YearRecord;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "ig_establishments_numberInpatientsCurrentActive")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NumberInpatientsCurrentActive{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;

    @OneToMany(mappedBy = "numberInpatientsCurrentActive", cascade = CascadeType.REMOVE)
    @OrderBy("year DESC")
    private List<YearRecord> yearRecords;

}
