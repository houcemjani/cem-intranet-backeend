package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;

public interface EntityProvider<T> {
    T retrieve(long var1) throws NoSuchObjectException;

    default String stringify(){
        return "test";
    }
}
