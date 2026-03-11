package com.sleeperapi.sleeperapi.pojo;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;
import java.util.Map;

public class EnrichedRoster extends RepresentationModel<EnrichedRoster> {

    private int rosterId;
    private String ownerId;
    private String displayName;
    private String teamName;
    private String avatar;
    private List<PlayerInfo> players;
    private List<PlayerInfo> starters;
    private Map<String, Object> settings;

    public EnrichedRoster(int rosterId, String ownerId, String displayName, String teamName,
                          String avatar, List<PlayerInfo> players, List<PlayerInfo> starters,
                          Map<String, Object> settings) {
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

    public String getOwnerId() {
        return ownerId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public String getTeamName() {
        return teamName;
    }

    public String getAvatar() {
        return avatar;
    }

    public List<PlayerInfo> getPlayers() {
        return players;
    }

    public List<PlayerInfo> getStarters() {
        return starters;
    }

    public Map<String, Object> getSettings() {
        return settings;
    }
}