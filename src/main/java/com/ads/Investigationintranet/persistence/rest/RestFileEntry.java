/*
 * Copyright (c) 2016.
 * This software is developed by Advanced Derivative Solutions and 3H Partners.
 * You may not copy this code or reproduce it.
 *
 */

package com.ads.Investigationintranet.persistence.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.dozer.Mapping;

@JsonInclude(Include.NON_EMPTY)
public class RestFileEntry {

    @JsonProperty
    private String hhhId;

    @JsonProperty
    private String name;

    @JsonProperty
    private String mimeType;

    @JsonProperty
    private String parentPath;

    @JsonProperty
    private String fullName;

    @JsonProperty
    private String author;

    @JsonProperty
    private String date;

    @Mapping("isDeletable.deletable")
    private boolean deletable;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String getParentPath() {
        return parentPath;
    }

    public void setParentPath(String parentPath) {
        this.parentPath = parentPath;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public boolean isDeletable() {
        return deletable;
    }

    public void setDeletable(boolean deletable) {
        this.deletable = deletable;
    }

    public String getHhhId() {
        return hhhId;
    }

    public void setHhhId(String hhhId) {
        this.hhhId = hhhId;
    }

}
