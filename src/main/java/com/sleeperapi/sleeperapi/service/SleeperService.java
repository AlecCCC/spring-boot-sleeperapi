package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.pojo.EnrichedRoster;
import com.sleeperapi.sleeperapi.pojo.matchup.Matchup;
import com.sleeperapi.sleeperapi.pojo.SleeperLeague;
import com.sleeperapi.sleeperapi.pojo.SleeperUser;
import com.sleeperapi.sleeperapi.pojo.matchup.SleeperMatchup;

import java.util.List;

public interface SleeperService {

    SleeperUser getSleeperUser(String username);

    List<SleeperUser> getLeagueUsers(String leagueId);


    List<SleeperLeague> getSleeperLeagues(String userId, String year);


    List<EnrichedRoster> getEnrichedRosters(String leagueId);



    List<Matchup> getMatchups(String leagueId, String week);


}
