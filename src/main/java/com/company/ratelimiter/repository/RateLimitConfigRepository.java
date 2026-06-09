package com.company.ratelimiter.repository;

import com.company.ratelimiter.entity.RateLimitConfig;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class RateLimitConfigRepository {

    private final Map<String, RateLimitConfig> configs =
            new ConcurrentHashMap<>();

    public void save(RateLimitConfig config) {
        configs.put(config.getEndpoint(), config);
    }

    public RateLimitConfig findByEndpoint(String endpoint) {
        return configs.get(endpoint);
    }

    public Map<String, RateLimitConfig> findAll() {
        return configs;
    }

    public void delete(String endpoint) {
        configs.remove(endpoint);
    }
}