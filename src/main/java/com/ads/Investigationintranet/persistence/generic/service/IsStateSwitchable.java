package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;

public class IsStateSwitchable {
    private boolean switchable = true;
    private String why;
    private HHHIdentifiable object;

    public IsStateSwitchable() {
    }

    public IsStateSwitchable(boolean switchable) {
        this.switchable = switchable;
    }

    public IsStateSwitchable(boolean switchable, String why) {
        this.switchable = switchable;
        this.why = why;
    }

    public IsStateSwitchable(boolean switchable, String why, HHHIdentifiable object) {
        this.switchable = switchable;
        this.why = why;
        this.object = object;
    }

    public boolean isSwitchable() {
        return this.switchable;
    }

    public void setSwitchable(boolean switchable) {
        this.switchable = switchable;
    }

    public String getWhy() {
        return this.why;
    }

    public void setWhy(String why) {
        this.why = why;
    }

    public HHHIdentifiable getObject() {
        return this.object;
    }

    public void setObject(HHHIdentifiable object) {
        this.object = object;
    }
}
