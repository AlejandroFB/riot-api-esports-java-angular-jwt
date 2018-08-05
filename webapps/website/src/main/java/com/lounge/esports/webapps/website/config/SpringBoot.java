package com.lounge.esports.webapps.website.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.PropertySource;

/**
 * Spring Boot configuration.
 *
 * @author afernandez
 */
@SpringBootApplication
@ComponentScan("com.lounge.esports")
@PropertySource(value = {"classpath:website.properties"}, ignoreResourceNotFound = true)
public class SpringBoot {

    public static void main(String[] args) {
        SpringApplication.run(SpringBoot.class, args);
    }
}
