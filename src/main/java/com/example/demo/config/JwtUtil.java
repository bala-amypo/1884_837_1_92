package com.example.demo.config;

import io.jsonwebtoken.*;
import java.util.*;

public class JwtUtil {

    private final String secret = "secret123";

    public String generateToken(Long id, String email, String role) {
        return Jwts.builder()
                .claim("userId", id)
                .claim("email", email)
                .claim("role", role)
                .signWith(SignatureAlgorithm.HS256, secret)
                .compact();
    }

    public Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(secret)
                .parseClaimsJws(token)
                .getBody();
    }
}
