

package com.ads.Investigationintranet.domain.trial.version;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Calendar;

public class Version {



    @JsonProperty
    private long hhhId;

    @JsonProperty
    private long lastHhhId;

    @JsonProperty
    private long ownerUserHhhId;

    @JsonProperty
    private VersionType versionType;

    @JsonProperty
    private Calendar creationDateTime;

    @JsonProperty
    private String entityClassName;

    @JsonProperty
    private long entityHhhId;

    @JsonProperty
    private Boolean active;


}
