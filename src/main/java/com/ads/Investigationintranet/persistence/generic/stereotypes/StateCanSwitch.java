package com.ads.Investigationintranet.persistence.generic.stereotypes;

public interface StateCanSwitch {
    void put(String var1, boolean var2);
    void put(StateManageable var1, boolean var2);
    boolean canSwitchTo(String var1);
    boolean canSwitchTo(StateManageable var1);
}
