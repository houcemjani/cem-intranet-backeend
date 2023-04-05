package com.ads.Investigationintranet.persistence.generic.stereotypes;

import java.util.List;

public interface Preloadable<T> {
    List<T> getAllPreloaded();
    void reinitPreloaded();
}
