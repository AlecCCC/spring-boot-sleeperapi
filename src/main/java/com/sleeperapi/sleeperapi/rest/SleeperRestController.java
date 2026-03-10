package com.sleeperapi.sleeperapi.rest;

import com.sleeperapi.sleeperapi.pojo.EnrichedRoster;
import com.sleeperapi.sleeperapi.pojo.SleeperUser;
import com.sleeperapi.sleeperapi.service.SleeperService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/sleeper")
public class SleeperRestController {


    private SleeperService sleeperService;

    public SleeperRestController(SleeperService sleeperService) {
        this.sleeperService = sleeperService;
    }

    @GetMapping("/user/{username}")
    public SleeperUser getUser(@PathVariable String username) {
        return sleeperService.getSleeperUser(username);
    }

    @GetMapping("/league/{leagueId}/rosters")
    public List<EnrichedRoster> getEnrichedRosters(@PathVariable String leagueId) {
        return sleeperService.getEnrichedRosters(leagueId);
    }


}
