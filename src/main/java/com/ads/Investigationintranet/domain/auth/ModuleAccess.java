package com.ads.Investigationintranet.domain.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Entity
@Table(name = "ig_module_access")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ModuleAccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "hhhId")
    private long hhhId;

    @Column(name = "readOnly")
    private Boolean readOnly;

    @Column(name = "readWrite")
    private Boolean readWrite;

    @Column(name = "noRight")
    private Boolean noRight;

    @Column(name = "export")
    private Boolean export;

    @Column(name = "partiallyExport")
    private Boolean partiallyExport;

    @Column(name = "notExport")
    private Boolean notExport;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "userHhhId")
    @JsonIgnore
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH, fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "moduleHhhId")
    private Module module;

}
