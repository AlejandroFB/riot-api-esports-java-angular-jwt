package com.lounge.esports.webapps.website.security.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lounge.esports.webapps.website.rest.AuthenticationSuccessResponse;
import com.lounge.esports.webapps.website.rest.error.Error;
import com.lounge.esports.webapps.website.rest.error.ErrorResponse;
import org.springframework.http.MediaType;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Utility class to use with Spring Security.
 *
 * @author afernandez
 */
public final class SecurityUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void sendError(HttpServletResponse response, Exception ex, int status, String message) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(status);

        PrintWriter writer = response.getWriter();
        Error error = new Error(message, ex.getMessage());
        writer.write(mapper.writeValueAsString(new ErrorResponse(status, error)));

        writer.flush();
        writer.close();
    }

    public static void sendResponse(HttpServletResponse response, int status, AuthenticationSuccessResponse message) throws IOException {
        response.setContentType(MediaType.APPLICATION_JSON_UTF8_VALUE);
        response.setStatus(status);

        PrintWriter writer = response.getWriter();
        writer.write(mapper.writeValueAsString(message));

        writer.flush();
        writer.close();
    }
}
