package com.it.cinemabackend.auth.repo;

import static java.lang.String.format;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    UserRepositoryMock userRepo;

    public UserService() {
        this.userRepo = new UserRepositoryMock();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
            .findByUsername(username)
            .orElseThrow(
                () -> new UsernameNotFoundException(format("User with username - %s, not found", username))
            );
    }
}
