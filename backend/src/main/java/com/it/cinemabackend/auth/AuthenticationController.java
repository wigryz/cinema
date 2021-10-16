package com.it.cinemabackend.auth;

import com.it.cinemabackend.auth.domain.dto.AuthRequest;
import com.it.cinemabackend.auth.domain.dto.RegisterRequest;
import com.it.cinemabackend.auth.domain.model.User;
import com.it.cinemabackend.auth.filter.JwtUtils;
import com.it.cinemabackend.auth.service.RoleService;
import com.it.cinemabackend.auth.service.UserService;
import java.time.LocalDateTime;
import java.util.Set;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final PasswordEncoder passwordEncoder;
    private final UserService userService;
    private final RoleService roleService;


    public AuthenticationController(AuthenticationManager authenticationManager,
                                    PasswordEncoder passwordEncoder,
                                    UserService userService, RoleService roleService) {
        this.authenticationManager = authenticationManager;
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
        this.roleService = roleService;
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody AuthRequest request) {
        try {
            Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        request.getUsername(), request.getPassword()
                    )
                );

            User user = (User) authenticate.getPrincipal();

            return ResponseEntity.ok()
                .header(HttpHeaders.AUTHORIZATION, JwtUtils.generateJWT(user))
                .body("Authorized successfully");
        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Long> register(@RequestBody RegisterRequest request) {
        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .createdAt(LocalDateTime.now())
            .roles(Set.of(roleService.findByName("ROLE_USER")))
            .build();
        userService.save(user);
        return ResponseEntity.ok(user.getId());
    }
}
