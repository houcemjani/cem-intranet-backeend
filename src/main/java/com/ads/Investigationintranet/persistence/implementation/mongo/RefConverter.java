package com.ads.Investigationintranet.persistence.implementation.mongo;

import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;
import org.bson.types.ObjectId;

public class RefConverter {
    public static RefConverter INSTANCE = new RefConverter();

    protected RefConverter() {
    }

    public long toHhhId(ObjectId id) {
        return id == null ? 0L : (long)id.getTimestamp() << 32 | (long)id.getInc() & 4294967295L;
    }

    public ObjectId getObjectId(HHHIdentifiable o) {
        return o == null ? null : this.toObjectId(o.getClass(), o.getHhhId());
    }

    public ObjectId toObjectId(Class<?> myClass, long hhhId) {
        if (hhhId == 0L) {
            return null;
        } else {
            int timeSeconds = (int)(hhhId >>> 32);
            int inc = (int)(hhhId & 4294967295L);
            return this.createObjectId(timeSeconds, myClass, inc);
        }
    }

    private ObjectId createObjectId(int timeSecond, Class<?> myClass, int inc) {
        return new ObjectId(timeSecond, this.getMachineReplacement(myClass), inc);
    }

    private int getMachineReplacement(Class<?> myClass) {
        String fixedName = myClass.getName();
        return fixedName.hashCode();
    }

    public ObjectId createObjectId(Class<?> myClass) {
        ObjectId mold = ObjectId.get();
        int timeSecond = mold.getTimeSecond();
        int inc = mold.getInc();
        return this.createObjectId(timeSecond, myClass, inc);
    }
}

