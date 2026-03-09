package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.dto.SleeperLeague;
import com.sleeperapi.sleeperapi.dto.SleeperLeagueRoster;
import com.sleeperapi.sleeperapi.dto.SleeperUser;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.List;

@Service
public class SleeperServiceImpl implements SleeperService{


    private final RestClient restClient;


    public SleeperServiceImpl(RestClient restClient) {
        this.restClient = restClient;
    }


    @Override
    public SleeperUser getSleeperUser(String username) {
        return restClient.get().uri("/user/{username}", username).retrieve().body(SleeperUser.class);
    }


    @Override
    public List<SleeperLeague> getLeagues(String username, String year) {

        SleeperUser user = getSleeperUser(username);
        String sleeperId = user.getUserId();

        return restClient.get()
                .uri("/user/{id}/leagues/nfl/{year}", sleeperId, year)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperLeague>>() {});
    }

    @Override
    public List<SleeperLeagueRoster> getRosters(String leagueId) {

        return restClient.get().uri("/league/{leagueId}/rosters", leagueId).retrieve().body(new ParameterizedTypeReference<List<SleeperLeagueRoster>>() {
        });

    }
}
