package com.company.ratelimiter.algorithm;

import org.springframework.stereotype.Component;

@Component
public class TokenBucketRateLimiter {

    public boolean isAllowed() {
        return true;
    }
}