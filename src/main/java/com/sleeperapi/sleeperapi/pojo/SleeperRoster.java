package com.sleeperapi.sleeperapi.pojo;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class SleeperRoster {

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

    public void setRosterId(int rosterId) {
        this.rosterId = rosterId;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public List<String> getPlayers() {
        return players;
    }

    public void setPlayers(List<String> players) {
        this.players = players;
    }

    public List<String> getStarters() {
        return starters;
    }

    public void setStarters(List<String> starters) {
        this.starters = starters;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, Object> settings) {
        this.settings = settings;
    }

    public Map<String, String> getMetadata() {
        return metadata;
    }

    public void setMetadata(Map<String, String> metadata) {
        this.metadata = metadata;
    }


}
