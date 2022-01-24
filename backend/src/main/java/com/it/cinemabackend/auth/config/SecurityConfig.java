package com.it.cinemabackend.auth.config;

import com.it.cinemabackend.auth.domain.model.Role;
import com.it.cinemabackend.auth.filter.JwtFilter;
import com.it.cinemabackend.auth.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    private final UserRepository userRepo;
    private final JwtFilter jwtFilter;

    public SecurityConfig(UserRepository userRepo, JwtFilter jwtFilter) {
        this.userRepo = userRepo;
        this.jwtFilter = jwtFilter;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> userRepo.findByUsername(username)
            .orElseThrow(() ->
                new UsernameNotFoundException(
                    String.format("User with username{%s} not found.", username))));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        // Enable CORS and disable CSRF
        http = http.cors().and().csrf().disable();

        // Set session management to stateless
        http = http
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and();

        http.authorizeRequests()
            // auth endpoints
            .antMatchers("/register").permitAll()
            .antMatchers("/login").permitAll()
            .antMatchers("/generate-token").permitAll()
            .antMatchers("/activate/**").permitAll()
            // public endpoints
//            .antMatchers("/api/**").permitAll()
            .antMatchers(HttpMethod.GET, "/api/**").permitAll()
            // private endpoints
            .antMatchers(HttpMethod.POST, "/api/**").hasRole(Role.ADMIN)
            .anyRequest().authenticated();

        // Add JWT token filter
        http.addFilterBefore(
            jwtFilter,
            UsernamePasswordAuthenticationFilter.class
        );
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    // Used by spring security if CORS is enabled.
    @Bean
    public CorsFilter corsFilter() {
        UrlBasedCorsConfigurationSource source =
            new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(false);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("*");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
