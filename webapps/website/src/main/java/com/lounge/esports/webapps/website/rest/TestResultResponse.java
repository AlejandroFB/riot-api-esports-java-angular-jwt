package com.lounge.esports.webapps.website.rest;

/**
 * Test Response to test rest endpoint until we have proper endpoints.
 *
 * @author afernandez
 */
public class TestResultResponse {
    private String message;

    public TestResultResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
