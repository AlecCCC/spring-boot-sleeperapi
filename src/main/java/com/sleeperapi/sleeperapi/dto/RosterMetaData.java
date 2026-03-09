package com.sleeperapi.sleeperapi.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RosterMetaData {

    private String record;
    private String streak;

    public RosterMetaData() {
    }

    public String getRecord() {
        return record;
    }

    public void setRecord(String record) {
        this.record = record;
    }

    public String getStreak() {
        return streak;
    }

    public void setStreak(String streak) {
        this.streak = streak;
    }
}
