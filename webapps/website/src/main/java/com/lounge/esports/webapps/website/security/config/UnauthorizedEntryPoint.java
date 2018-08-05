package com.lounge.esports.webapps.website.security.config;

import com.lounge.esports.webapps.website.security.util.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Custom AuthenticationEntryPoint to avoid default Spring Security redirecting to login page.
 * In our case it's needed just a http status 401 and a json response.
 *
 * @author afernandez
 */
@Component
public class UnauthorizedEntryPoint implements AuthenticationEntryPoint {

    private static final String AUTH_FAILED = "Authentication failed";

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException ex) throws IOException, ServletException {
        SecurityUtils.sendError(response, ex, HttpStatus.UNAUTHORIZED.value(), AUTH_FAILED);
    }
}
