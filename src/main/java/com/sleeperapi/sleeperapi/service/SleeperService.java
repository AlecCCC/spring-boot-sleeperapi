package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.dto.SleeperLeague;
import com.sleeperapi.sleeperapi.dto.SleeperLeagueRoster;
import com.sleeperapi.sleeperapi.dto.SleeperUser;
import com.sleeperapi.sleeperapi.dto.league_user_data.SleeperLeagueUser;
import com.sleeperapi.sleeperapi.dto.league_user_data.SleeperRosterWithUser;

import java.util.List;

public interface SleeperService {

    SleeperUser getSleeperUser(String username);

    List<SleeperLeague> getLeagues(String username, String year);

    List<SleeperLeagueRoster> getRosters(String leagueId);

    List<SleeperLeagueUser> getLeagueUsers(String leagueId);

    List<SleeperRosterWithUser> getRostersWithUsers(String leagueId);



}
