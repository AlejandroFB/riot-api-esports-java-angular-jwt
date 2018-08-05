package com.lounge.esports.webapps.website.rest;

/**
 * Information added to the response sent after a successful authentication. It was created to include the
 * JWT token.
 *
 * @author afernandez
 */
public class AuthenticationSuccessResponse {

    private String userName;
    private String token;

    public AuthenticationSuccessResponse(String userName, String token) {
        this.userName = userName;
        this.token = token;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
