package com.lounge.esports.webapps.website.security.authentication;

import com.lounge.esports.webapps.website.security.util.SecurityUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Custom handler for Spring Security that will be triggered when a object does not hold a required
 * authority.
 *
 * @author afernandez
 */
@Component
public class CustomAccessDeniedHandler implements AccessDeniedHandler {

    private static final String FORBIDDEN_MESSAGE = "Not authorized resources";

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException ex) throws IOException, ServletException {
        SecurityUtils.sendError(response, ex, HttpStatus.FORBIDDEN.value(), FORBIDDEN_MESSAGE);
    }
}
