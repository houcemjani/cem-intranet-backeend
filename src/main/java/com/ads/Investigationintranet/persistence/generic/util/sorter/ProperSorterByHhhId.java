package com.ads.Investigationintranet.persistence.generic.util.sorter;

import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;
import com.ads.Investigationintranet.persistence.generic.stereotypes.ProperSorter;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ProperSorterByHhhId<P> implements ProperSorter<P> {
    private List<P> objects;
    private Map<Long, Integer> objectPosition = new HashMap();

    private void sortObjects(List<P> objects) {
        Collections.sort(objects, new Comparator<P>() {
            public int compare(P object1, P object2) {
                return (new Long(((HHHIdentifiable)object1).getHhhId() - ((HHHIdentifiable)object2).getHhhId())).intValue();
            }
        });
    }

    public ProperSorterByHhhId(List<P> objects) {
        this.sortObjects(objects);
        int i = 0;

        for(Iterator<P> i2$ = objects.iterator(); i2$.hasNext(); ++i) {
            P p = i2$.next();
            this.objectPosition.put(((HHHIdentifiable)p).getHhhId(), i);
        }

        this.objects = objects;
    }

    public List getAllProperlySorted() {
        return this.objects;
    }

    public boolean isBefore(Object o1, Object o2) {
        boolean returnValue = true;

        try {
            returnValue = (Integer)this.objectPosition.get(((HHHIdentifiable)o1).getHhhId()) < (Integer)this.objectPosition.get(((HHHIdentifiable)o2).getHhhId());
        } catch (Exception var5) {
        }

        return returnValue;
    }

    public boolean isEqualOrBefore(Object o1, Object o2) {
        boolean returnValue = true;

        try {
            returnValue = (Integer)this.objectPosition.get(((HHHIdentifiable)o1).getHhhId()) <= (Integer)this.objectPosition.get(((HHHIdentifiable)o2).getHhhId());
        } catch (Exception var5) {
        }

        return returnValue;
    }

    public boolean isAfter(Object o1, Object o2) {
        return (Integer)this.objectPosition.get(((HHHIdentifiable)o1).getHhhId()) > (Integer)this.objectPosition.get(((HHHIdentifiable)o2).getHhhId());
    }

    public boolean isEqualOrAfter(Object o1, Object o2) {
        return (Integer)this.objectPosition.get(((HHHIdentifiable)o1).getHhhId()) >= (Integer)this.objectPosition.get(((HHHIdentifiable)o2).getHhhId());
    }

    public boolean isFirst(Object o) {
        return (Integer)this.objectPosition.get(((HHHIdentifiable)o).getHhhId()) == 0;
    }

    public boolean isLast(Object o) {
        return (Integer)this.objectPosition.get(((HHHIdentifiable)o).getHhhId()) == this.objects.size() - 1;
    }
}

