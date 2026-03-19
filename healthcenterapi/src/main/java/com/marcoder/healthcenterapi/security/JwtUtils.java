package com.marcoder.healthcenterapi.security;

import java.security.Key;
import java.util.Date;

import io.jsonwebtoken.*;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

@Component
public class JwtUtils {

    private final String jwtSecret = "AY9a7Fm`_V{E*z_/VcI-P0/KJN6L1k)mp@!k}]E";
    private final int jwtExpirationMs = 86400000;
    private final Key key = Keys.hmacShaKeyFor(jwtSecret.getBytes());

    public String generateJwtToken(Authentication authentication) {

        UserDetails userPrincipal = (UserDetails) authentication.getPrincipal();

        return Jwts.builder()
                .setSubject((userPrincipal.getUsername()))
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime() + jwtExpirationMs))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

    }

    public String getUserNameFromJwtToken(String token) {

        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();

    }

    public boolean validateJwtToken(String authToken){
        try{
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(authToken);
            return true;
        }catch(MalformedJwtException e){
            System.err.println("Invalid JWT token: " + e.getMessage());
        }catch(ExpiredJwtException e){
            System.err.println("Expired JWT token: " + e.getMessage());
        }catch(UnsupportedJwtException e){
            System.err.println("Unsupported JWT token: " + e.getMessage());
        }catch(IllegalArgumentException e){
            System.err.println("JWT claims string is empty: " + e.getMessage());
        }catch(SecurityException e){
            System.err.println("JWT signature verification failed: " + e.getMessage());
        }
        return false;
    }

}
