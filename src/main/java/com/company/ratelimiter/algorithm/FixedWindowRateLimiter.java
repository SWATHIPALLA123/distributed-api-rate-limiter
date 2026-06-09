package com.company.ratelimiter.algorithm;

import org.springframework.stereotype.Component;

@Component
public class FixedWindowRateLimiter {

    public boolean isAllowed(String clientId,
                             String endpoint,
                             int limit,
                             long windowSeconds) {

        return true;
    }
}