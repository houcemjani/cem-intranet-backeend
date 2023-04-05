package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.stereotypes.StateCanSwitch;
import com.ads.Investigationintranet.persistence.generic.stereotypes.StateManageable;

import java.util.HashMap;
import java.util.Map;

public class StateCanSwitchMap implements StateCanSwitch {
    private Map<String, Boolean> canSwitch = new HashMap();

    public StateCanSwitchMap() {
    }

    public void put(String stateName, boolean can) {
        this.canSwitch.put(stateName, new Boolean(can));
    }

    public void put(StateManageable state, boolean can) {
        this.put(state.getCode(), can);
    }

    public boolean canSwitchTo(String stateName) {
        return !this.canSwitch.containsKey(stateName) ? false : (Boolean)this.canSwitch.get(stateName);
    }

    public boolean canSwitchTo(StateManageable state) {
        return this.canSwitchTo(state.getCode());
    }
}
