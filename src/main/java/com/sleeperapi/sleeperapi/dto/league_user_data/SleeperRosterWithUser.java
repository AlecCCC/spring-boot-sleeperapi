package com.sleeperapi.sleeperapi.dto.league_user_data;

import com.sleeperapi.sleeperapi.dto.SleeperLeagueRoster;

public class SleeperRosterWithUser {

    private SleeperLeagueRoster sleeperLeagueRoster;
    private String displayName;
    private String teamname;
    private String userAvatar;

    public SleeperRosterWithUser() {
    }

    public SleeperRosterWithUser(SleeperLeagueRoster sleeperLeagueRoster, String displayName, String teamname, String avatar) {
        this.sleeperLeagueRoster = sleeperLeagueRoster;
        this.displayName = displayName;
        this.teamname = teamname;
        this.userAvatar = avatar;
    }

    public SleeperLeagueRoster getSleeperLeagueRoster() {
        return sleeperLeagueRoster;
    }

    public void setSleeperLeagueRoster(SleeperLeagueRoster sleeperLeagueRoster) {
        this.sleeperLeagueRoster = sleeperLeagueRoster;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getAvatar() {
        return userAvatar;
    }

    public void setAvatar(String avatar) {
        this.userAvatar = avatar;
    }
}
