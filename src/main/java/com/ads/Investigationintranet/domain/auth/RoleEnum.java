package com.ads.Investigationintranet.domain.auth;

public enum RoleEnum {
    CRA,
    DOCTOR,
    ADMIN(DOCTOR, CRA),
    EDITOR(ADMIN),
    MANAGER,
    ACCOUNTANT,
    NURSE,
    TECHNICIAN;

    private final RoleEnum[] inheritedRoles;

    RoleEnum(RoleEnum... inheritedRoles) {
        this.inheritedRoles = inheritedRoles;
    }

    public RoleEnum[] getInheritedRoles() {
        return inheritedRoles;
    }
}
