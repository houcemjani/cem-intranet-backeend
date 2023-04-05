package com.ads.Investigationintranet.persistence.generic.service;

import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;
import com.ads.Investigationintranet.persistence.generic.exceptions.PersistException;
import com.ads.Investigationintranet.persistence.generic.stereotypes.DAO;
import com.ads.Investigationintranet.persistence.generic.stereotypes.HHHIdentifiable;

import java.util.List;

public interface Service<P> {
    DAO getDAO();
    P retrieve(long var1) throws NoSuchObjectException;
    P persist(P var1) throws PersistException;
    List<P> persistList(List<P> var1) throws PersistException;
    P persistFields(P var1, String... var2) throws PersistException;
    boolean isNew(HHHIdentifiable var1);
    IsDeletable isDeletable(P var1);
    IsDeletable isDeletable(long var1);
    void delete(P var1);
}
