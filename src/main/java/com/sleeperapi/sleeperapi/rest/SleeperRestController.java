package com.sleeperapi.sleeperapi.rest;

import com.sleeperapi.sleeperapi.pojo.EnrichedRoster;
import com.sleeperapi.sleeperapi.pojo.SleeperLeague;
import com.sleeperapi.sleeperapi.pojo.SleeperUser;
import com.sleeperapi.sleeperapi.service.SleeperService;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/api/sleeper")
public class SleeperRestController {

    private SleeperService sleeperService;

    public SleeperRestController(SleeperService sleeperService) {
        this.sleeperService = sleeperService;
    }

    @GetMapping("/user/{username}")
    public SleeperUser getUser(@PathVariable String username) {

        SleeperUser user = sleeperService.getSleeperUser(username);

        String currentYear = String.valueOf(java.time.Year.now().getValue() - 1);

        // Self link + link to get this user's leagues
        user.add(linkTo(methodOn(SleeperRestController.class).getUser(username)).withSelfRel());
        user.add(linkTo(methodOn(SleeperRestController.class).getUserLeagues(user.getUserId(), currentYear)).withRel("leagues"));

        return user;
    }

    @GetMapping("/user/{userId}/leagues/{year}")
    public CollectionModel<SleeperLeague> getUserLeagues(@PathVariable String userId, @PathVariable String year) {
        List<SleeperLeague> leagues = sleeperService.getSleeperLeagues(userId, year);

        for (SleeperLeague league : leagues) {
            league.add(linkTo(methodOn(SleeperRestController.class).getUserLeagues(userId, year)).withSelfRel());
            league.add(linkTo(methodOn(SleeperRestController.class).getLeagueUsers(league.getLeagueId())).withRel("users"));
            league.add(linkTo(methodOn(SleeperRestController.class).getEnrichedRosters(league.getLeagueId())).withRel("rosters"));
        }

        return CollectionModel.of(leagues,
                linkTo(methodOn(SleeperRestController.class).getUserLeagues(userId, year)).withSelfRel()
        );
    }

    @GetMapping("/league/{leagueId}/users")
    public CollectionModel<SleeperUser> getLeagueUsers(@PathVariable String leagueId) {
        List<SleeperUser> users = sleeperService.getLeagueUsers(leagueId);

        for (SleeperUser user : users) {
            user.add(linkTo(methodOn(SleeperRestController.class).getLeagueUsers(leagueId)).withSelfRel());
        }

        return CollectionModel.of(users,
                linkTo(methodOn(SleeperRestController.class).getLeagueUsers(leagueId)).withSelfRel(),
                linkTo(methodOn(SleeperRestController.class).getEnrichedRosters(leagueId)).withRel("rosters")
        );
    }

    @GetMapping("/league/{leagueId}/rosters")
    public CollectionModel<EnrichedRoster> getEnrichedRosters(@PathVariable String leagueId) {
        List<EnrichedRoster> rosters = sleeperService.getEnrichedRosters(leagueId);

        for (EnrichedRoster roster : rosters) {
            roster.add(linkTo(methodOn(SleeperRestController.class).getEnrichedRosters(leagueId)).withSelfRel());
        }

        return CollectionModel.of(rosters,
                linkTo(methodOn(SleeperRestController.class).getEnrichedRosters(leagueId)).withSelfRel(),
                linkTo(methodOn(SleeperRestController.class).getLeagueUsers(leagueId)).withRel("users")
        );
    }

    @GetMapping("/user/{username}/leagues/search/{year}")
    public CollectionModel<SleeperLeague> getUserLeaguesByUsername(
            @PathVariable String username,
            @PathVariable String year) {

        // Step 1: get userId from username
        SleeperUser user = sleeperService.getSleeperUser(username);

        // Step 2: get leagues using userId
        List<SleeperLeague> leagues = sleeperService.getSleeperLeagues(user.getUserId(), year);

        for (SleeperLeague league : leagues) {
            league.add(linkTo(methodOn(SleeperRestController.class).getUserLeaguesByUsername(username, year)).withSelfRel());
            league.add(linkTo(methodOn(SleeperRestController.class).getLeagueUsers(league.getLeagueId())).withRel("users"));
            league.add(linkTo(methodOn(SleeperRestController.class).getEnrichedRosters(league.getLeagueId())).withRel("rosters"));
        }

        return CollectionModel.of(leagues,
                linkTo(methodOn(SleeperRestController.class).getUserLeaguesByUsername(username, year)).withSelfRel()
        );
    }


}