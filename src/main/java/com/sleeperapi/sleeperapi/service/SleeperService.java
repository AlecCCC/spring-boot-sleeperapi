package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.pojo.EnrichedRoster;
import com.sleeperapi.sleeperapi.pojo.SleeperUser;

import java.util.List;

public interface SleeperService {

    SleeperUser getSleeperUser(String username);

    List<EnrichedRoster> getEnrichedRosters(String leagueId);


}
