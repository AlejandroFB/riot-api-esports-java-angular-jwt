package com.lounge.esports.webapps.website.security.token;

import com.lounge.esports.webapps.website.security.authentication.UserAuthentication;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

/**
 * When a user successfully logs into the web application, the first public method of this class will be called to
 * create a token for that user.
 *
 * @author afernandez
 */
@Service
public class TokenAuthenticationService {

    @Autowired
    private TokenHandler tokenHandler;

    public String generateToken(User user) {
        return tokenHandler.createTokenForUser(user);
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        final String token = request.getHeader(HttpHeaders.AUTHORIZATION);
        if (StringUtils.isNotEmpty(token) && token.startsWith("Bearer")) {
            final User user = tokenHandler.parseUserFromToken(token.split(" ")[1]);
            if (user != null) {
                return new UserAuthentication(user);
            }
        }
        return null;
    }
}