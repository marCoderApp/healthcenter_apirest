package com.marcoder.healthcenterapi.security;

import org.hibernate.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final UserDetailsService userDetailsService;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.userDetailsService = userDetailsService;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    //IT DEFINES HOW TO AUTHENTICATE USERS
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {

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
    public SecurityFilterChain filterChain(HttpSecurity http, AuthenticationProvider authenticationProvider) throws Exception {

        http    .cors(cors -> cors.disable())
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                ))
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.POST,"/auth/**").permitAll()
                        .requestMatchers(HttpMethod.GET,"/branch/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/branch/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/branch/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/branch/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/branch/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/department/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/department/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/department/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/department/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/department/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/consulting_room/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/consulting_room/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/consulting_room/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/consulting_room/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/consulting_room/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/user/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/user/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/user/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/user/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/user/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/doctor/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/doctor/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/doctor/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/doctor/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/doctor/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/speciallty/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/speciallty/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/speciallty/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/speciallty/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/speciallty/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.GET,"/patient/**").hasAnyRole("ADMIN", "RECEPCIONIST")
                        .requestMatchers(HttpMethod.POST,"/patient/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PUT,"/patient/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.DELETE,"/patient/**").hasAnyRole("ADMIN")
                        .requestMatchers(HttpMethod.PATCH,"/patient/**").hasAnyRole("ADMIN")
                        .anyRequest().authenticated());
                http.authenticationProvider(authenticationProvider());
                http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);


    return http.build();
    }


}
