package com.ads.Investigationintranet.persistence.generic.stereotypes;

public interface StateManageable<P extends HHHIdentifiable> {
    long getHhhId();
    void setHhhId(long var1);
    String getCode();
    void setCode(String var1);
    String getName();
}
