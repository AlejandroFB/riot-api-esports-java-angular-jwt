package com.lounge.esports.services.riot.exception;

import com.lounge.esports.services.riot.api.rest.RestBaseResponse;

/**
 * Runtime exception thrown in the case a rest response is not successful.
 *
 * @author afernandez
 */
public class IllegalRestCallException extends IllegalStateException {
    private RestBaseResponse response;

    public IllegalRestCallException(String s, RestBaseResponse response) {
        super(s);
        this.response = response;
    }

    public RestBaseResponse getResponse() {
        return response;
    }
}
