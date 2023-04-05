package com.ads.Investigationintranet.persistence.generic.stereotypes;

public interface StateHaving {
    boolean canSwitchToState(String var1, StateManageable var2);
    boolean canSwitchToState(String var1, String var2);
}
