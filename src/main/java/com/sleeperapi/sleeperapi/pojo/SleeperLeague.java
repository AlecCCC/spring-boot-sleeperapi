package com.sleeperapi.sleeperapi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperLeague {

    private String name;

    private String avatar;

    public SleeperLeague() {
    }

    public String getName() {
        return name;
    }

    public String getAvatar() {
        return avatar;
    }
}
