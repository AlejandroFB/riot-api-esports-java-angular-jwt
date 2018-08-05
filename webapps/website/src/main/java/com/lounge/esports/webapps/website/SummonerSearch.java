package com.lounge.esports.webapps.website;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

/**
 * Summoner search input variables.
 *
 * @author afernandez
 */
public class SummonerSearch {

    @NotEmpty(message = "Summoner name cannot be empty")
    @Pattern(message = "Summoner name is not a valid name", regexp = "^[0-9\\p{L} _\\.]+$")
    private String name;

    @NotEmpty(message = "Region cannot be empty")
    private String region;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
}