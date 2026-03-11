package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.pojo.EnrichedRoster;
import com.sleeperapi.sleeperapi.pojo.SleeperLeague;
import com.sleeperapi.sleeperapi.pojo.SleeperUser;

import java.util.List;

public interface SleeperService {

    SleeperUser getSleeperUser(String username);

    List<SleeperLeague> getSleeperLeagues(String userId, String year);

    List<EnrichedRoster> getEnrichedRosters(String leagueId);

    List<SleeperUser> getLeagueUsers(String leagueId);


}
