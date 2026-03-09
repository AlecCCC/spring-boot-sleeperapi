package com.sleeperapi.sleeperapi.service;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
@EnableScheduling
public class NFLPlayerData {

    RestClient restClient;

    public NFLPlayerData(RestClient restClient) {
        this.restClient = restClient;
    }

}
