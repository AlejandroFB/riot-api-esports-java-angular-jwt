package com.lounge.esports.services.riot.rest;

import com.lounge.esports.services.riot.api.RiotApiRegion;
import com.lounge.esports.services.riot.api.rest.Summoner;
import com.lounge.esports.services.riot.util.RiotApiHelper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;

/**
 * Summoner API method service.
 *
 * The service only accepts one summoner name for now. In the future
 * it will be needed to implement this service to handle multiple summoner names.
 *
 * @author afernandez
 */
@Service
public class SummonerRestService extends GenericRiotRestService<Summoner> {

    @Value("${riot.endpoint.summoner}")
    private String summonerEndpoint;

    public SummonerRestService() {
        super(Summoner.class);
    }

    @Override
    protected String buildEndpointUrl(RiotApiRegion region, String ... summonerNames) {
        return MessageFormat.format(summonerEndpoint, region.getRegion(), RiotApiHelper.convertToString(summonerNames));
    }
}
