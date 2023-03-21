package com.ads.Investigationintranet.domain.auth;

import com.ads.Investigationintranet.domain.CustomExport;
import com.ads.Investigationintranet.domain.Establishment;
import com.ads.Investigationintranet.domain.HumanResource;
import com.ads.Investigationintranet.domain.humanResource.Responsability;
import com.ads.Investigationintranet.domain.mobile.TrialMessage;
import com.ads.Investigationintranet.entity.Speciality;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "ig_auth_users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User  {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @OneToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY)
    @JoinColumn(name = "humanResourceHhhId", referencedColumnName = "hhhId")
    private HumanResource humanResource;

    @Column(name = "userName", unique = true)
    private String userName;

    @Column(name = "title")
    private String title;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "duty")
    private String duty;

    @Column(name = "passwordEncrypted")
    private String passwordEncrypted;

    @Column(name = "lastPasswordChangeDate")
    private Date lastPasswordChangeDate;

    @Transient
    private char[] passwordUnencrypted;

    @Transient
    private char[] newPassword1;

    @Transient
    private char[] newPassword2;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "activationDate")
    private Date activationDate;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "roleHhhId")
    private Role role;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    @Fetch(FetchMode.SUBSELECT)
    private List<ModuleAccess> moduleAccesses;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "establishmentHhhId")
    private Establishment establishment;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customExportHhhId", referencedColumnName = "hhhId")
    private CustomExport customExport;

    private Integer tokenFailedAttempts;

    @Column(name = "changedPassword")
    private Boolean changedPassword = true;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_responsabilities")
    private List<Responsability> responsability;

    @Column(name = "isMobileActive", columnDefinition = "boolean default false")
    private Boolean isMobileActive;

    @Column(name = "lastMobileConnection")
    private String lastMobileConnection;

    @Column(name = "nbrOfConnectionPerMonth")
    private String nbrOfConnectionPerMonth;

    @Column(name = "isUserForMobileOnly")
    private Boolean isMobileOnly;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ig_mobile_users_2_specialities",
            joinColumns = {@JoinColumn(name = "userHhhId", referencedColumnName = "hhhId")},
            inverseJoinColumns = {@JoinColumn(name = "specialityHhhId", referencedColumnName = "hhhId")})
    @OrderBy("hhhId ASC")
    @JsonIgnore
    private Collection<Speciality> specialities = new ArrayList<>();

    @OneToMany(mappedBy = "emitter", cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<TrialMessage> sentMessages;

    @OneToMany(mappedBy = "receiver", cascade = CascadeType.ALL)
    @OrderBy("hhhId ASC")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<TrialMessage> receivedMessages;

}
