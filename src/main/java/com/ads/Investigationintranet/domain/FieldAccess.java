package com.ads.Investigationintranet.domain;

import com.ads.Investigationintranet.domain.auth.User;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Table(name = "ig_field_access")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class FieldAccess {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "userHhhId")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "moduleHhhId")
    private HiddenField hiddenField;

    @Column
    private Boolean canAccess ;

}
