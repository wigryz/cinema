package com.it.cinemabackend.auth.repo;

import com.it.cinemabackend.auth.domain.Role;
import com.it.cinemabackend.auth.domain.User;

import java.util.Optional;
import java.util.Set;

public class UserRepositoryMock {

    public Optional<User> findByUsername(String username) {
        Optional<User> user = Optional.empty();
        if (username.equals("user")) {
            user = Optional.of(new User(0L, "user", "pass", Set.of(new Role(Role.USER))));
        }
        if (username.equals("admin")) {
            user = Optional.of(new User(1L, "admin", "pass", Set.of(new Role(Role.ADMIN))));
        }

        return user;
    }
}
