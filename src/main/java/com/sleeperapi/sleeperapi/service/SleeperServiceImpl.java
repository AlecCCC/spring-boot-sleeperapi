package com.sleeperapi.sleeperapi.service;

import com.sleeperapi.sleeperapi.dto.SleeperUser;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

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
}
