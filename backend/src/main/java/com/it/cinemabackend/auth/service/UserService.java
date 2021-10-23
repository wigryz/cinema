package com.it.cinemabackend.auth.service;

import com.it.cinemabackend.auth.domain.model.User;
import com.it.cinemabackend.auth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo
            .findByUsername(username)
            .orElseThrow(() -> new UsernameNotFoundException("User not found."));
    }

    public Iterable<User> loadUsers() {
        return userRepo.findAll();
    }

    public void activateAccount(String username) {
        User user = userRepo.findByUsername(username).orElseThrow();
        user.setEnabled(true);
        userRepo.save(user);
    }

    public User save(User user) {
        return userRepo.save(user);
    }
}
