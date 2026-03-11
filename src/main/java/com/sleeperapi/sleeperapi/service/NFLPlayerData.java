package com.sleeperapi.sleeperapi.service;
import jakarta.annotation.PostConstruct;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;
import tools.jackson.core.type.TypeReference;
import tools.jackson.databind.ObjectMapper;


import java.io.File;
import java.util.HashMap;
import java.util.Map;

@Service
public class NFLPlayerData {

   private final RestClient restClient;
   private final ObjectMapper objectMapper;

    private Map<String, Object> players = new HashMap<>();


    public NFLPlayerData(RestClient restClient, ObjectMapper objectMapper) {
        this.restClient = restClient;
        this.objectMapper = objectMapper;
    }

    @PostConstruct
    public void loadPlayers() throws Exception {
        File file = new File("players.json");
        if (file.exists()) {
            players = objectMapper.readValue(file, new TypeReference<Map<String, Object>>() {});
        } else {
            fetchAndSavePlayers();
        }
    }

    @Scheduled(cron = "0 0 0 * * *")
    public void fetchAndSavePlayers() throws Exception {
        players = restClient.get()
                .uri("/players/nfl")
                .retrieve()
                .body(new ParameterizedTypeReference<Map<String, Object>>() {});

        objectMapper.writeValue(new File("players.json"), players);
    }

    public RestClient getRestClient() {
        return restClient;
    }

    public ObjectMapper getObjectMapper() {
        return objectMapper;
    }

    public Map<String, Object> getPlayers() {
        return players;
    }
}
