package com.lounge.esports.services.riot;

import com.lounge.esports.services.riot.api.RiotApiRegion;
import com.lounge.esports.services.riot.api.rest.Summoner;
import com.lounge.esports.services.riot.rest.SummonerRestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Main class to perform call to the RIOT API.
 *
 * @author afernandez
 */
@Service
public class RiotApi {

    @Autowired
    private SummonerRestService summonerRestService;

    public Summoner getSummonerByName(final RiotApiRegion region, final String summonerName) {
        return summonerRestService.invoke(region, summonerName);
    }
}