package com.lounge.esports.services.riot.util;

import org.apache.commons.lang3.ArrayUtils;

/**
 * Helper class to perform utility actions to RIOT API endpoints.
 *
 * @author afernandez
 */
public final class RiotApiHelper {

    /**
     * Always retrieves the first summoner name from the ones passed to the that's the case.
     * Applies an additional clean up to the name result and returns it as a string.
     *
     * @param summonerNames Array of summoner names
     * @return The first summoner name
     */
    public static String convertToString(String ... summonerNames) {
        if (ArrayUtils.isEmpty(summonerNames)) {
            throw new IllegalArgumentException("Summoner name must not be null.");
        }
        return summonerNames[0].toLowerCase().replaceAll("\\s+", "");
    }
}
