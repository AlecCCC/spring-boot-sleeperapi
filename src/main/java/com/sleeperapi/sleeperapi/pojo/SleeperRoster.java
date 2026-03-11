package com.sleeperapi.sleeperapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Map;

public class SleeperRoster extends RepresentationModel<SleeperRoster> {

    @JsonProperty("roster_id")
    int rosterId;
    @JsonProperty("owner_id")
    String ownerId;
    @JsonProperty("players")
    List<String> players;
    @JsonProperty("starters")
    List<String> starters;
    @JsonProperty("settings")
    Map<String, Object> settings;
    @JsonProperty("metadata") Map<String, String> metadata;


    public int getRosterId() {
        return rosterId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public List<String> getPlayers() {
        return players;
    }

    public List<String> getStarters() {
        return starters;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }
}
