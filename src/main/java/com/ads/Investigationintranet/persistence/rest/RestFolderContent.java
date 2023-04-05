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

import java.util.List;

@JsonInclude(Include.NON_EMPTY)
public class RestFolderContent {

    @JsonProperty
    private String hhhId;

    @JsonProperty
    private String name;

    @JsonProperty
    private String fullName;

    @JsonProperty
    private List<RestFileEntry> folders;

    @JsonProperty
    private List<RestFileEntry> files;

    @JsonProperty
    private Boolean root = false;

    private String date;

    private String author;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<RestFileEntry> getFolders() {
        return folders;
    }

    public void setFolders(List<RestFileEntry> folders) {
        this.folders = folders;
    }

    public List<RestFileEntry> getFiles() {
        return files;
    }

    public void setFiles(List<RestFileEntry> files) {
        this.files = files;
    }

    public Boolean getRoot() {
        return root;
    }

    public void setRoot(Boolean root) {
        this.root = root;
    }

    public String getHhhId() {
        return hhhId;
    }

    public void setHhhId(String hhhId) {
        this.hhhId = hhhId;
    }
}
