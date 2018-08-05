package com.lounge.esports.webapps.website;

import com.lounge.esports.services.riot.RiotApi;
import com.lounge.esports.services.riot.api.RiotApiRegion;
import com.lounge.esports.services.riot.api.rest.Summoner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Controller to load the login page.
 *
 * @author afernandez
 */
@Controller
public class MainController {

    @Autowired
    private RiotApi riotApi;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndex() {
        return "index";
    }

    @ResponseBody
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Summoner getSummonerInfo(@Validated SummonerSearch summonerSearch) {
        return riotApi.getSummonerByName(RiotApiRegion.valueOf(summonerSearch.getRegion()), summonerSearch.getName());
    }
}
