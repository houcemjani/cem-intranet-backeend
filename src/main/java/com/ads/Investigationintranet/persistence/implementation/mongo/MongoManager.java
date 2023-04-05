package com.ads.Investigationintranet.persistence.implementation.mongo;

import com.ads.Investigationintranet.persistence.generic.stereotypes.Manager;
import com.mongodb.BasicDBList;

import java.util.List;

public interface MongoManager extends Manager {
    <P> List<P> resolveReferences(BasicDBList var1, Class<P> var2);
    <P> P refresh(P var1);
}
