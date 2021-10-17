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
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
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
    public ResponseEntity<String> register(@RequestBody RegisterRequest request) {

        String token = JwtUtils.generateActivationToken(request.getUsername());

        User user = User.builder()
            .username(request.getUsername())
            .password(passwordEncoder.encode(request.getPassword()))
            .firstName(request.getFirstName())
            .lastName(request.getLastName())
            .email(request.getEmail())
            .enabled(false)
            .createdAt(LocalDateTime.now())
            .roles(Set.of(roleService.findByName("ROLE_USER")))
            .build();
        userService.save(user);

        return ResponseEntity.ok(token);
    }

    @GetMapping("/generate-token")
    public ResponseEntity<String> generateToken(@RequestBody RegisterRequest request) {
        UserDetails user = userService.loadUserByUsername(request.getUsername());
        if (!passwordEncoder.matches(request.getPassword(), user.getPassword())) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        } else {
            if (user.isEnabled())
                return ResponseEntity.status(HttpStatus.ALREADY_REPORTED).build();
            else {
                String token = JwtUtils.generateActivationToken(request.getUsername());
                return ResponseEntity.ok(token);
            }
        }

    }

    @PostMapping("/activate/{token}")
    public ResponseEntity<String> activate(@PathVariable String token) {

        if (JwtUtils.validateActivationToken(token)) {
            String username = JwtUtils.getUsername(token);
            userService.activateAccount(username);
            return ResponseEntity.ok("Account activated.");
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid token.");
    }
}
