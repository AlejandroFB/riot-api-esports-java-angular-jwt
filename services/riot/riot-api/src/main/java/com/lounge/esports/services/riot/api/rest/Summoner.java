package com.lounge.esports.services.riot.api.rest;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.lounge.esports.services.riot.api.util.SummonerDeserializer;

/**
 * This class contains summoner information.
 *
 * @author afernandez
 */
@JsonDeserialize(using = SummonerDeserializer.class)
public class Summoner extends RestBaseResponse {

    private long id;
    private String name;
    private int profileIconId;
    private long summonerLevel;
    private long revisionDate;

    public Summoner() {
    }

    public Summoner(long id, String name, int profileIconId, long summonerLevel, long revisionDate) {
        this.id = id;
        this.name = name;
        this.profileIconId = profileIconId;
        this.summonerLevel = summonerLevel;
        this.revisionDate = revisionDate;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getProfileIconId() {
        return profileIconId;
    }

    public long getSummonerLevel() {
        return summonerLevel;
    }

    public long getRevisionDate() {
        return revisionDate;
    }
}
