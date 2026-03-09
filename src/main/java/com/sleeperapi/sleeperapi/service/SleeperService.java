package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.dto.SleeperLeague;
import com.sleeperapi.sleeperapi.dto.SleeperUser;

import java.util.List;

public interface SleeperService {

    SleeperUser getSleeperUser(String username);

    List<SleeperLeague> getLeagues(String username, String year);



}
