package com.company.ratelimiter.algorithm;

import org.springframework.stereotype.Component;

@Component
public class SlidingWindowRateLimiter {

    public boolean isAllowed() {
        return true;
    }
}
