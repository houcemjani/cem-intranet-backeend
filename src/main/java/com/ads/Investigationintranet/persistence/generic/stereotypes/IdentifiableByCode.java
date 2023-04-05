package com.ads.Investigationintranet.persistence.generic.stereotypes;

public interface IdentifiableByCode<T> {
    T getByCode(String var1);
}