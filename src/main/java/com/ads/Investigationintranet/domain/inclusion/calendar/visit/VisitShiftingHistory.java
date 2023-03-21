package com.ads.Investigationintranet.domain.inclusion.calendar.visit;

import com.ads.Investigationintranet.domain.auth.User;
import com.ads.Investigationintranet.domain.inclusion.calendar.Visit;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name = "ig_visit_shifting_history")
public class VisitShiftingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;

    @Column()
    private Date date;

    @ManyToOne
    private User user;

    private Long value;

    @ManyToOne()
    private Visit visit;

    @ManyToOne
    private Visit visitCompareTo;

    public VisitShiftingHistory() {
    }
}
