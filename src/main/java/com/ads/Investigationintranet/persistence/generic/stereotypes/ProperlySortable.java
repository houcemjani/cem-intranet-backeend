package com.ads.Investigationintranet.persistence.generic.stereotypes;

import java.util.List;

public interface ProperlySortable<P> {
    List<P> getAllProperlySorted();
    ProperSorter<P> getProperSorter();
}
