package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;

public class IsDeletable {
    private boolean deletable = true;
    private String why;
    private HHHIdentifiable object;

    public IsDeletable() {
    }

    public IsDeletable(boolean deletable) {
        this.deletable = deletable;
    }

    public IsDeletable(boolean deletable, String why) {
        this.deletable = deletable;
        this.why = why;
    }

    public IsDeletable(boolean deletable, String why, HHHIdentifiable object) {
        this.deletable = deletable;
        this.why = why;
        this.object = object;
    }

    public boolean isDeletable() {
        return this.deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
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

