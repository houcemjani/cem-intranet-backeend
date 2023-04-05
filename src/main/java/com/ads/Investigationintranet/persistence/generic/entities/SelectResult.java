package com.ads.Investigationintranet.persistence.generic.entities;

import com.ads.Investigationintranet.persistence.generic.exceptions.NoSuchObjectException;

import java.util.ArrayList;
import java.util.List;

public class SelectResult<P> {
    public long foundTotal;
    public long fetchedFrom;
    public long fetchedTo;
    public List<P> results;

    public SelectResult() {
    }

    public long getFetchedTotal() {
        return (long)this.results.size();
    }

    public long getFoundTotal() {
        return this.foundTotal;
    }

    public void setFoundTotal(long foundTotal) {
        this.foundTotal = foundTotal;
    }

    public long getFetchedFrom() {
        return this.fetchedFrom;
    }

    public void setFetchedFrom(long fetchedFrom) {
        this.fetchedFrom = fetchedFrom;
    }

    public long getFetchedTo() {
        return this.fetchedTo;
    }

    public void setFetchedTo(long fetchedTo) {
        this.fetchedTo = fetchedTo;
    }

    public List<P> getResults() {
        return (List)(this.results == null ? new ArrayList() : this.results);
    }

    public void setResults(List<P> results) {
        this.results = results;
    }

    public P getSingleResult() throws NoSuchObjectException {
        if (this.results != null && !this.results.isEmpty() && this.results.size() == 1) {
            return this.results.iterator().next();
        } else if (this.results.size() > 1) {
            throw new NoSuchObjectException("Select query returned more than one result");
        } else {
            return null;
        }
    }
}

