package com.sleeperapi.sleeperapi.dto.league_user_data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperLeagueUser {

    private String avatar;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "league_id")
    private String leagueId;

    @JsonProperty("user_id")
    private String userId;

    @JsonProperty(value = "metadata")
    private SleeperLeagueUserMetaData metaData;

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getLeagueId() {
        return leagueId;
    }

    public void setLeagueId(String leagueId) {
        this.leagueId = leagueId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public SleeperLeagueUserMetaData getMetaData() {
        return metaData;
    }

    public void setMetaData(SleeperLeagueUserMetaData metaData) {
        this.metaData = metaData;
    }
}
