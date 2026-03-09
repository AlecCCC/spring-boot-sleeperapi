package com.sleeperapi.sleeperapi.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperLeague {

    @JsonProperty(value = "league_id")
    private String leagueId;

    @JsonProperty(value = "name")
    private String league_name;

    @JsonProperty(value = "draft_id")
    private String draftId;

    private String season;

    private String[] roster_positions;

    private String avatar;

    private String latest_league_winner_roster_id;


    public SleeperLeague() {
    }

    public String getLatest_league_winner_roster_id() {
        return latest_league_winner_roster_id;
    }

    public void setLatest_league_winner_roster_id(String latest_league_winner_roster_id) {
        this.latest_league_winner_roster_id = latest_league_winner_roster_id;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String[] getRoster_positions() {
        return roster_positions;
    }

    public void setRoster_positions(String[] roster_positions) {
        this.roster_positions = roster_positions;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getDraftId() {
        return draftId;
    }

    public void setDraftId(String draftId) {
        this.draftId = draftId;
    }

    public String getLeague_name() {
        return league_name;
    }

    public void setLeague_name(String league_name) {
        this.league_name = league_name;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }
}
