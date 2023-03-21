package com.ads.Investigationintranet.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ig_token_store")
public class Token  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "username")
    private String username;

    @Column(name = "token")
    private String token;

    @Column(name = "expires")
    private long expires;

}
