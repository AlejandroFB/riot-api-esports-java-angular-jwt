package com.lounge.esports.services.riot.api.util;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import com.lounge.esports.services.riot.api.rest.Summoner;

import java.io.IOException;

/**
 * Custom deserializer for the Summoner class. The RIOT API endpoint returns
 * a JSON representation of a Map<String, Summoner> and the key is dynamically
 * generated as the summoner name.
 *
 * @author afernandez
 */
public class SummonerDeserializer extends StdDeserializer<Summoner> {

    public SummonerDeserializer() {
        this(null);
    }

    public SummonerDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public Summoner deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException {
        JsonNode node = jp.getCodec().readTree(jp);
        JsonNode next = node.elements().next();

        long id = next.get("id").longValue();
        String name = next.get("name").asText();
        int profileIconId = next.get("profileIconId").intValue();
        long summonerLevel = next.get("summonerLevel").longValue();
        long revisionDate = next.get("revisionDate").longValue();

        return new Summoner(id, name, profileIconId, summonerLevel, revisionDate);
    }
}
