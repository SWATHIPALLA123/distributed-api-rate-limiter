package com.company.ratelimiter.repository;

import com.company.ratelimiter.redis.RedisService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class RedisRateLimitRepository {

    private final RedisService redisService;

    public Long incrementCounter(String key) {
        return redisService.increment(key);
    }

    public void setExpiry(String key, long seconds) {
        redisService.setExpiry(key, seconds);
    }

    public Long getCounter(String key) {
        return redisService.getValue(key);
    }

    public Long getTTL(String key) {
        return redisService.getRemainingTTL(key);
    }
}