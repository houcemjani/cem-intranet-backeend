package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;

public interface StateManaging<P extends HHHIdentifiable> {
    StateManager<P> getStateManager();
}