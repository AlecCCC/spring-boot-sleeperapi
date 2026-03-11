package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.pojo.*;
import com.sleeperapi.sleeperapi.pojo.matchup.Matchup;
import com.sleeperapi.sleeperapi.pojo.matchup.MatchupPlayer;
import com.sleeperapi.sleeperapi.pojo.matchup.SleeperMatchup;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SleeperServiceImpl implements SleeperService {

    private final RestClient restClient;
    private final NFLPlayerData nflPlayerData;

    public SleeperServiceImpl(RestClient restClient, NFLPlayerData nflPlayerData) {
        this.restClient = restClient;
        this.nflPlayerData = nflPlayerData;
    }

    @Override
    public SleeperUser getSleeperUser(String username) {
        return restClient.get()
                .uri("/user/{username}", username)
                .retrieve()
                .body(SleeperUser.class);
    }

    @Override
    public List<SleeperLeague> getSleeperLeagues(String userId, String year) {
        return restClient.get()
                .uri("/user/{username}/leagues/nfl/{year}", userId, year)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperLeague>>() {
                });
    }

    @Override
    public List<SleeperUser> getLeagueUsers(String leagueId) {
        return restClient.get()
                .uri("/league/{leagueId}/users", leagueId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperUser>>() {
                });
    }


    @Override
    public List<Matchup> getMatchups(String leagueId, String week) {

        List<SleeperMatchup> raw = restClient.get()
                .uri("/league/{leagueId}/matchups/{week}", leagueId, week)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperMatchup>>() {});


        List<Matchup> result = new ArrayList<>();

        for (SleeperMatchup matchup : raw) {


            List<MatchupPlayer> starters = convertToMatchupPlayer(matchup.getStarters(), matchup.getPlayersPoints());
            List<MatchupPlayer> players = convertToMatchupPlayer(matchup.getPlayers(), matchup.getPlayersPoints());


            result.add(new Matchup(
                    matchup.getRosterId(),
                    matchup.getMatchupId(),
                    matchup.getPoints(),
                    starters,
                    players
            ));
        }

        return result;
    }


    @Override
    public List<EnrichedRoster> getEnrichedRosters(String leagueId) {

        List<SleeperUser> users = restClient.get()
                .uri("/league/{leagueId}/users", leagueId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperUser>>() {});

        List<SleeperRoster> rosters = restClient.get()
                .uri("/league/{leagueId}/rosters", leagueId)
                .retrieve()
                .body(new ParameterizedTypeReference<List<SleeperRoster>>() {});

        // Build user lookup map
        Map<String, SleeperUser> userMap = new HashMap<>();

        for (SleeperUser user : users) {
            userMap.put(user.getUserId(), user);
        }

        List<EnrichedRoster> enrichedRosters = new ArrayList<>();

        for (SleeperRoster roster : rosters) {

            SleeperUser matchedUser = userMap.get(roster.getOwnerId());

            String displayName;
            String teamName;
            String avatar;

            if (matchedUser != null) {
                displayName = matchedUser.getDisplayName();
                avatar = matchedUser.getAvatar();
                if (matchedUser.getMetadata() != null && matchedUser.getMetadata().getTeamName() != null) {
                    teamName = matchedUser.getMetadata().getTeamName();
                } else {
                    teamName = null;
                }
            } else {
                displayName = "Unknown";
                teamName = "Unknown Team";
                avatar = null;
            }

            // Convert player ID lists to PlayerInfo lists
            List<PlayerInfo> playerInfoList = convertToPlayerInfo(roster.getPlayers());
            List<PlayerInfo> starterInfoList = convertToPlayerInfo(roster.getStarters());

            EnrichedRoster enrichedRoster = new EnrichedRoster(
                    roster.getRosterId(),
                    roster.getOwnerId(),
                    displayName,
                    teamName,
                    avatar,
                    playerInfoList,
                    starterInfoList,
                    roster.getSettings()
            );

            enrichedRosters.add(enrichedRoster);
        }

        return enrichedRosters;
    }



//    HELPER FUNCTIONS

    private List<MatchupPlayer> convertToMatchupPlayer(List<String> playerIds, Map<String, Double> playerPoints) {

        if (playerIds == null) {
            return new ArrayList<>();
        }

        List<MatchupPlayer> result = new ArrayList<>();
        Map<String, Object> allPlayers = nflPlayerData.getPlayers();

        for (String playerId : playerIds) {

            if (playerId.equals("0")) {
                continue;
            }

            Map<String, Object> playerData = (Map<String, Object>) allPlayers.get(playerId);
            double points = playerPoints != null ? playerPoints.getOrDefault(playerId, 0.0) : 0.0;

            if (playerData != null) {
                String firstName = (String) playerData.get("first_name");
                String lastName = (String) playerData.get("last_name");
                String position = (String) playerData.get("position");
                result.add(new MatchupPlayer(playerId, firstName, lastName, position, points));
            } else {
                result.add(new MatchupPlayer(playerId, "Unknown", "Unknown", "Unknown", points));
            }
        }

        return result;
    }
    // Takes a list of player IDs, looks each one up in the players.json map
    private List<PlayerInfo> convertToPlayerInfo(List<String> playerIds) {

        List<PlayerInfo> result = new ArrayList<>();

        Map<String, Object> allPlayers = nflPlayerData.getPlayers();

        for (String playerId : playerIds) {

            Map<String, Object> playerData = (Map<String, Object>) allPlayers.get(playerId);

            if (playerData != null) {
                String firstName = (String) playerData.get("first_name");
                String lastName = (String) playerData.get("last_name");
                String position = (String) playerData.get("position");
                result.add(new PlayerInfo(playerId, firstName, lastName, position));
            } else {
                result.add(new PlayerInfo(playerId, "Unknown", "Unknown", "Unknown"));
            }
        }

        return result;
    }


}
