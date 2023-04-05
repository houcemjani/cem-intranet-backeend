package com.ads.Investigationintranet.persistence.implementation.mongo;

import com.mongodb.BasicDBList;
import java.util.AbstractList;
import java.util.List;

public class LazyMongoList<E> extends AbstractList<E> {
    private final MongoManager manager;
    private final BasicDBList mongoList;
    private final Class<E> targetClass;
    private transient List<E> cached;

    public LazyMongoList(MongoManager manager, BasicDBList mongoList, Class<E> targetClass) {
        this.manager = manager;
        this.mongoList = mongoList;
        this.targetClass = targetClass;
    }

    public E get(int index) {
        if (this.cached == null) {
            this.cached = this.manager.resolveReferences(this.mongoList, this.targetClass);
        }

        return this.cached.get(index);
    }

    public int size() {
        return this.cached == null ? this.mongoList.size() : this.cached.size();
    }

    public E set(int index, E element) {
        if (this.cached == null) {
            this.cached = this.manager.resolveReferences(this.mongoList, this.targetClass);
        }

        return this.cached.set(index, element);
    }

    public void add(int index, E element) {
        if (this.cached == null) {
            this.cached = this.manager.resolveReferences(this.mongoList, this.targetClass);
        }

        this.cached.add(index, element);
    }

    public E remove(int index) {
        if (this.cached == null) {
            this.cached = this.manager.resolveReferences(this.mongoList, this.targetClass);
        }

        return this.cached.remove(index);
    }
}

