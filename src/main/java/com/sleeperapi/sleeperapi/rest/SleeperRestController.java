package com.sleeperapi.sleeperapi.rest;

import com.sleeperapi.sleeperapi.dto.SleeperLeague;
import com.sleeperapi.sleeperapi.dto.SleeperLeagueRoster;
import com.sleeperapi.sleeperapi.dto.SleeperUser;
import com.sleeperapi.sleeperapi.dto.league_user_data.SleeperLeagueUser;
import com.sleeperapi.sleeperapi.dto.league_user_data.SleeperRosterWithUser;
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

    @GetMapping("/user/{username}/leagues/{year}")
        public List<SleeperLeague> getLeagues(@PathVariable String username, @PathVariable String year) {
        return sleeperService.getLeagues(username, year);
    }

    @GetMapping("/league/{leagueId}/league-users")
    public List<SleeperLeagueUser> getLeagueUsers(@PathVariable String leagueId) {
        return sleeperService.getLeagueUsers(leagueId);
    }

    @GetMapping("/league/{leagueId}/rosters")
    public List<SleeperRosterWithUser> getRosters(@PathVariable String leagueId) {
        return sleeperService.getRostersWithUsers(leagueId);
    }


}
