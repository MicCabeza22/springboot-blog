package com.codeup.springbootblog.services;

import com.codeup.springbootblog.models.User;
import com.codeup.springbootblog.models.UserWithRoles;
import com.codeup.springbootblog.repositories.Users;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsLoader implements UserDetailsService {
    private final Users users;

    public UserDetailsLoader(Users users) {
        this.users = users;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = users.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("No user for " + username);
        }

        return new UserWithRoles(user);
    }
}