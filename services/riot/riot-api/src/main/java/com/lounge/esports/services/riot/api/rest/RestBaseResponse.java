package com.lounge.esports.services.riot.api.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Rest base response to be used by RIOT API responses.
 *
 * @author afernandez
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class RestBaseResponse {

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this, ToStringStyle.DEFAULT_STYLE);
    }
}
