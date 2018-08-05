package com.lounge.esports.webapps.website.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Web MVC configuration.
 *
 * @author afernandez
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/styles/**", "/build/**", "/app/**", "/templates/**")
                .addResourceLocations("classpath:/styles/", "classpath:/build/", "classpath:/app/",
                        "classpath:/templates/");
    }
}
