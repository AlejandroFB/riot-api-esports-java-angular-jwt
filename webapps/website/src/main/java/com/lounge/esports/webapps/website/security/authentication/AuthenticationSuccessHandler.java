package com.lounge.esports.webapps.website.security.authentication;

import com.lounge.esports.webapps.website.rest.AuthenticationSuccessResponse;
import com.lounge.esports.webapps.website.security.util.SecurityUtils;
import com.lounge.esports.webapps.website.security.token.TokenAuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * The login success handler returns http status 200 with user info in json format.
 *
 * @author afernandez
 */
@Component
public class AuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        String userName = request.getParameter("username");
        String password = request.getParameter("password");

        final User user =  new User(userName, password, authentication.getAuthorities());

        final String token = tokenAuthenticationService.generateToken(user);
        SecurityUtils.sendResponse(response, HttpStatus.OK.value(), new AuthenticationSuccessResponse(user.getUsername(), token));
    }
}
