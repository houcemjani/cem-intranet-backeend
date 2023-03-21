

package com.ads.Investigationintranet.domain;


import com.ads.Investigationintranet.domain.contactableMember.ContactableMember;
import com.ads.Investigationintranet.domain.trial.TrialSiteLiaison;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_sites")
public class Site {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    @JsonProperty
    private long hhhId;

    @Column(name = "name")
    @JsonProperty
    private String name;

    @JsonIgnore
    @OneToMany(mappedBy = "site", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.LAZY)
    @OrderBy("hhhId ASC")
//    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<TrialSiteLiaison> trialSiteLiaisons = new ArrayList<>();

    @OneToMany(mappedBy = "site", cascade = CascadeType.REMOVE, orphanRemoval = true, fetch = FetchType.EAGER)
    @OrderBy("hhhId ASC")
    private Collection<ContactableMember> contactableMembers = new ArrayList<>();

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER)
    @JoinColumn(name = "establishmentHhhId")

    private Establishment establishment;

}
