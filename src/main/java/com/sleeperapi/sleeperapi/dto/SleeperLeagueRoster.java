package com.sleeperapi.sleeperapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperLeagueRoster {

    @JsonProperty(value = "league_id")
    private String leagueId;

    @JsonProperty(value = "metadata")
    private RosterMetaData rosterMetaData;

    @JsonProperty(value="owner_id")
    private String ownerId;

    @JsonProperty(value = "roster_id")
    private String rosterId;

    private String[] players;

    private String[] starters;

    public SleeperLeagueRoster() {
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public RosterMetaData getRosterMetaData() {
        return rosterMetaData;
    }

    public void setRosterMetaData(RosterMetaData rosterMetaData) {
        this.rosterMetaData = rosterMetaData;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getRosterId() {
        return rosterId;
    }

    public void setRosterId(String rosterId) {
        this.rosterId = rosterId;
    }

    public String[] getPlayers() {
        return players;
    }

    public void setPlayers(String[] players) {
        this.players = players;
    }

    public String[] getStarters() {
        return starters;
    }

    public void setStarters(String[] starters) {
        this.starters = starters;
    }
}
