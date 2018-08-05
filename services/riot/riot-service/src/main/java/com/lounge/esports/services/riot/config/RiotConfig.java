package com.lounge.esports.services.riot.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.client.RestTemplate;

/**
 * Spring Boot configuration class for Riot Service.
 *
 * @author afernandez
 */
@Configuration
@PropertySource(value = {"classpath:riot.properties"}, ignoreResourceNotFound = true)
public class RiotConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplateBuilder().build();
    }
}
