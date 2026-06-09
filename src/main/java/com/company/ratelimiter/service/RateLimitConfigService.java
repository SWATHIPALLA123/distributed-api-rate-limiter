package com.company.ratelimiter.service;

import com.company.ratelimiter.dto.ConfigRequestDto;
import com.company.ratelimiter.entity.RateLimitConfig;

import java.util.Map;

public interface RateLimitConfigService {

    RateLimitConfig create(ConfigRequestDto dto);

    Map<String, RateLimitConfig> getAll();

    void delete(String endpoint);
}