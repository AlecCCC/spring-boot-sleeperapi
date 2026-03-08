package com.sleeperapi.sleeperapi.configure;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class SleeperConfigure {

    @Bean
    public RestClient restClient() {
        return RestClient.builder()
                .baseUrl("https://api.sleeper.app/v1")
                .defaultHeader("Content-Type", "application/json")
                .build();
    }


}
