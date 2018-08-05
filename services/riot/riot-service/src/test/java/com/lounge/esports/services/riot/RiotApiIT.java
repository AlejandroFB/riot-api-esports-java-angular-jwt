package com.lounge.esports.services.riot;

import com.lounge.esports.services.riot.api.RiotApiRegion;
import com.lounge.esports.services.riot.api.rest.Summoner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Basic Integration Tests for the RiotApi entry point.
 *
 * @author afernandez
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = {RiotApiTestConfiguration.class})
public class RiotApiIT {

    private final String SUMMONER_NAME = "AT Halovenen";

    @Autowired
    private RiotApi riotApi;

    @Test
    public void getSummonerByName() throws Exception {
        final Summoner summoner = riotApi.getSummonerByName(RiotApiRegion.EUW, SUMMONER_NAME);

        assertNotNull(summoner);
        assertEquals(30, summoner.getSummonerLevel());
        assertEquals(SUMMONER_NAME, summoner.getName());
    }
}