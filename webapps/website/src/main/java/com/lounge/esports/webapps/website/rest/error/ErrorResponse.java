package com.lounge.esports.webapps.website.rest.error;

/**
 * ErrorResponse POJO to return response data to the client.
 *
 * @author afernandez
 */
public class ErrorResponse {

    private int code;
    private Error error;

    public ErrorResponse(int code, Error error) {
        this.code = code;
        this.error = error;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
