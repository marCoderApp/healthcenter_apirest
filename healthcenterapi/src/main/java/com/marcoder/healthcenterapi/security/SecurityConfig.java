package com.marcoder.healthcenterapi.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    //IT DEFINES HOW TO AUTHENTICATE USERS
    @Bean
    public DaoAuthenticationProvider daoAuthenticationProvider() {

        //TO SEARCH USERS
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);

        //TO VALIDATE PASSWORD
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    //IT DEFINES HOW THE PASSWORDS ARE ENCRYPTED
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //IT EXPOSES AUTHENTICATIONMANAGER TO USE IN THE CODE
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfig) throws Exception {

        return authConfig.getAuthenticationManager();
    }

    //IT DEFINES WHO CAN ACCESS TO ENDPOINTS (HTTP SECURITY)
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    return null;
    }


}
