

package com.ads.Investigationintranet.domain;





import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_trials")
public class TrialBase   {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "name")
    private String name;

    @Column(name = "initials")
    private String initials;

    @Column(name = "protocolNumber")
    private String protocolNumber;

    @Column(name = "otherCodes")
    private String otherCodes;

    @Column(name = "localIdentifier")
    private String localIdentifier;

    @Column(name = "abbreviatedName")
    private String abbreviatedName;

    @Column(name = "multiSite")
    private boolean multiSite;

    @Column(name = "manualState")
    private boolean manualState;

}
