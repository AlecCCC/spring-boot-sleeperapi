package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.pojo.EnrichedRoster;
import com.sleeperapi.sleeperapi.pojo.SleeperRoster;
import com.sleeperapi.sleeperapi.pojo.SleeperUser;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public List<EnrichedRoster> getEnrichedRosters(String leagueId) {

        List<SleeperUser> users = restClient.get()
                .uri("/league/{leagueId}/users",leagueId).retrieve()
                .body(new ParameterizedTypeReference<List<SleeperUser>>() {
        });

        List<SleeperRoster> rosters = restClient.get()
                .uri("/league/{leagueId}/rosters", leagueId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperRoster>>() {
                });

        Map<String, SleeperUser> userMap = new HashMap<>();

        for (SleeperUser tempuser: users) {
            userMap.put(tempuser.getUserId(), tempuser);
        }

        List<EnrichedRoster> enrichedRosters = new ArrayList<>();

        for (SleeperRoster roster : rosters) {

            SleeperUser matchedUser = userMap.get(roster.getOwnerId());

            String displayName;
            String teamName;
            String avatar;

            if (matchedUser != null) {
                displayName = matchedUser.getDisplayName();
                teamName = matchedUser.getMetadata().getTeamName();
                avatar = matchedUser.getAvatar();
            }
            else {
                displayName = "Unknown";
                teamName = "Unknown Team";
                avatar = null;
            }

            EnrichedRoster enrichedRoster = new EnrichedRoster(
                    roster.getRosterId(),
                    roster.getOwnerId(),
                    displayName,
                    teamName,
                    avatar,
                    roster.getPlayers(),
                    roster.getStarters(),
                    roster.getSettings()
            );

            enrichedRosters.add(enrichedRoster);


        }

        return enrichedRosters;

    }

}
