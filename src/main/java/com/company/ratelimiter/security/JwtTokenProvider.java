package com.company.ratelimiter.security;

import org.springframework.stereotype.Component;

@Component
public class JwtTokenProvider {

    public boolean validateToken(String token) {
        return token != null && !token.isBlank();
    }
}