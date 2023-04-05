package com.ads.Investigationintranet.persistence.generic.stereotypes;

import java.util.List;

public interface ProperSorter<P> {
    List<P> getAllProperlySorted();
    boolean isBefore(P var1, P var2);
    boolean isAfter(P var1, P var2);
    boolean isEqualOrBefore(P var1, P var2);
    boolean isEqualOrAfter(P var1, P var2);
    boolean isFirst(P var1);
    boolean isLast(P var1);
}
