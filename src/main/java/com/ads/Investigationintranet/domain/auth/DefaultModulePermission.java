package com.ads.Investigationintranet.domain.auth;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "default_module_permissions")
public class DefaultModulePermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long hhhId;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Role role;
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Module module;

    private boolean readOnly;
    private boolean readWrite;
    private boolean noRight;
    private boolean export;
    private boolean partialExport;
    private boolean noExport;

}
