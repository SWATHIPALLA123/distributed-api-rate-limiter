package com.company.ratelimiter.redis;

import org.springframework.stereotype.Component;

@Component
public class RedisKeyGenerator {

    public String generateKey(String clientId, String endpoint) {
        return "rate_limit:" + clientId + ":" + endpoint;
    }
}