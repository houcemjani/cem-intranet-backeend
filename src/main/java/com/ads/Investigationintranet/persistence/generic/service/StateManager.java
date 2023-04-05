package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;
import com.ads.Investigationintranet.persistence.generic.stereotypes.StateManageable;

public interface StateManager<P extends HHHIdentifiable> {
    IsStateSwitchable canSwitch(P var1, StateManageable var2);

    IsStateSwitchable canSwitch(long var1, String var3);

    IsStateSwitchable canSwitch(P var1, StateManageable var2, StateManageable var3);

    IsStateSwitchable canSwitch(P var1, String var2, StateManageable var3);

    IsStateSwitchable canSwitch(long var1, String var3, String var4);

    IsStateSwitchable canSwitch(P var1, String var2, StateManageable var3, StateManageable var4);

    IsStateSwitchable canSwitch(long var1, String var3, String var4, String var5);
}
