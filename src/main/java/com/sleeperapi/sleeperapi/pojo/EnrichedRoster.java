package com.sleeperapi.sleeperapi.pojo;

import java.util.List;
import java.util.Map;

public class EnrichedRoster {

    int rosterId;
    String ownerId;
    String displayName;
    String teamName;
    String avatar;
    List<String> players;
    List<String> starters;
    Map<String, Object> settings;

    public EnrichedRoster() {
    }

    public EnrichedRoster(int rosterId, String ownerId, String displayName, String teamName, String avatar, List<String> players, List<String> starters, Map<String, Object> settings) {
        this.rosterId = rosterId;
        this.ownerId = ownerId;
        this.displayName = displayName;
        this.teamName = teamName;
        this.avatar = avatar;
        this.players = players;
        this.starters = starters;
        this.settings = settings;
    }

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
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
}
