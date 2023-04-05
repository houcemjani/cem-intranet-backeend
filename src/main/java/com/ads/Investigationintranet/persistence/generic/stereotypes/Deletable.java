package com.ads.Investigationintranet.persistence.generic.stereotypes;

import com.ads.Investigationintranet.persistence.generic.service.IsDeletable;

public interface Deletable {
    void setDeletable(IsDeletable var1);
    IsDeletable isDeletable();
}