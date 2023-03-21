package com.ads.Investigationintranet.domain.trial;

import com.ads.Investigationintranet.domain.Site;
import com.ads.Investigationintranet.entity.ReportsTrial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ig_trial_site_liaisons")
public class ReportsTrialSiteLiaison {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "siteHhhId")
    private Site site;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "trialHhhId")
    private ReportsTrial trial;

}