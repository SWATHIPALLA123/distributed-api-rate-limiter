package com.company.ratelimiter.redis;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
@RequiredArgsConstructor
public class RedisService {

    private final StringRedisTemplate redisTemplate;

    public Long increment(String key) {
        return redisTemplate.opsForValue().increment(key);
    }

    public void setExpiry(String key, long seconds) {
        redisTemplate.expire(key, seconds, TimeUnit.SECONDS);
    }

    public Long getValue(String key) {
        String value = redisTemplate.opsForValue().get(key);

        if (value == null) {
            return 0L;
        }

        return Long.parseLong(value);
    }

    public Long getRemainingTTL(String key) {
        return redisTemplate.getExpire(key);
    }
}