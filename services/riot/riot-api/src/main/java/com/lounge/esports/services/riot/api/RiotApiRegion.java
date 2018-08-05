package com.lounge.esports.services.riot.api;

/**
 * Represents the different possible regions to use in the RIOT Api.
 *
 * @author afernandez
 */
public enum RiotApiRegion {

    BR("br.api.pvp.net", "br"),
    EUNE("eune.api.pvp.net", "eune"),
    EUW("euw.api.pvp.net", "euw"),
    JP("jp.api.pvp.net", "jp"),
    KR("kr.api.pvp.net", "kr"),
    LAN("lan.api.pvp.net", "lan"),
    LAS("las.api.pvp.net", "las"),
    NA("na.api.pvp.net", "na"),
    OCE("oce.api.pvp.net", "oce"),
    TR("tr.api.pvp.net", "tr"),
    RU("ru.api.pvp.net", "ru"),
    PBE("pbe.api.pvp.net", "pbe"),
    GLOBAL("global.api.pvp.net", "global");

    private String apiUrl;
    private String region;

    RiotApiRegion(String apiUrl, String region) {
        this.apiUrl = apiUrl;
        this.region = region;
    }

    public String getApiUrl() {
        return apiUrl;
    }

    public String getRegion() {
        return region;
    }
}
