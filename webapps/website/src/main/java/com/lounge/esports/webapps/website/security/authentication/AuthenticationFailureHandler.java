package com.lounge.esports.webapps.website.security.authentication;

import com.lounge.esports.webapps.website.security.util.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The login fail handler returns http status 401.
 *
 * @author afernandez
 */
@Component
public class AuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

    private static final String AUTH_FAILED = "Authentication failed";

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        SecurityUtils.sendError(response, ex, HttpStatus.UNAUTHORIZED.value(), AUTH_FAILED);
    }
}