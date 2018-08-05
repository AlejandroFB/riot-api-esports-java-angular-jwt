package com.lounge.esports.webapps.website.security.config;

import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implementation of Spring Security's UserDetailsService.
 *
 * @author afernandez
 */
@Service
public class UserService implements UserDetailsService {

    private final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();

    private Map<String, User> generateNewUserList(Map<String, User> users) {
        SimpleGrantedAuthority auth = new SimpleGrantedAuthority("GAMER");
        List<SimpleGrantedAuthority> auths = new ArrayList<>();
        auths.add(auth);

        final User firstUser = new User("firstUser", "1234", auths);
        final User secondUser = new User("secondUser", "xxxx", auths);
        final User thirdUser = new User("thirdUser", "yyyy", auths);

        users.put(firstUser.getUsername(), firstUser);
        users.put(secondUser.getUsername(), secondUser);
        users.put(thirdUser.getUsername(), thirdUser);

        return users;
    }

    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        // Simulate DB to store users
        final Map<String, User> users = new HashMap<>();
        generateNewUserList(users);

        final User user = users.get(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found.");
        }

        detailsChecker.check(user);
        return user;
    }
}
