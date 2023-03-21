package com.ads.Investigationintranet.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_auth_user_attempts")
public class UserAttempt  {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "username")
    private String username;

    @Column(name = "lastConnectionAttempt")
    private Date lastConnectionAttempt;

    @Column(name = "successed")
    private boolean successed;

    @Column(name = "remoteAddress")
    private String remoteAddress;

    @Column(name = "DoubleAuthenticated")
    private boolean doubleAuthenticated;

}
