package com.sleeperapi.sleeperapi.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SleeperUser {

    private String avatar;

    private String league_id;

    @JsonProperty(value = "display_name")
    private String displayName;

    @JsonProperty(value = "user_id")
    private String userId;

    @JsonProperty(value = "username")
    private String userName;

    private Metadata metadata;

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Metadata {

        @JsonProperty(value = "team_name")
        private String teamName;

        public String getTeamName() {
            return teamName;
        }

    }

    public String getAvatar() {
        return avatar;
    }


    public String getDisplayName() {
        return displayName;
    }


    public String getUserId() {
        return userId;
    }




    public Metadata getMetadata() {
        return metadata;
    }


    public String getLeague_id() {
        return league_id;
    }

    @Override
    public String toString() {
        return "SleeperUser{" +
                "avatar='" + avatar + '\'' +
                ", displayName='" + displayName + '\'' +
                ", userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", metadata=" + metadata +
                '}';
    }
}