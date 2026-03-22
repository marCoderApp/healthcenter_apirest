package com.marcoder.healthcenterapi.security;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.marcoder.healthcenterapi.model.User;
import lombok.Getter;
import org.jspecify.annotations.Nullable;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

public class UserDetailsImpl implements UserDetails {
    @Getter
    private Long id;
    private String username;
    @Getter
    private String email;

    @JsonIgnore
    private String password;

    // ENUMS
    private Collection<? extends GrantedAuthority> authorities;


    public UserDetailsImpl(Long id,
                           String username,
                           String email,
                           Collection<? extends GrantedAuthority> authorities,
                           String password) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.authorities = authorities;
        this.password = password;
    }

    public static UserDetailsImpl build(User user) {
        List<GrantedAuthority> authorities =
                List.of(new SimpleGrantedAuthority("ROLE_" + user.getRole().name()));

        return new UserDetailsImpl(user.getUser_id(),
                user.getUsername(),
                user.getEmail(),
                authorities,
                user.getPassword());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public @Nullable String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    public Long getId() {
        return this.id;
    }

    public String getEmail() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return UserDetails.super.isAccountNonExpired();
    }

}
