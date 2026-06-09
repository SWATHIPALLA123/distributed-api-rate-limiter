package com.company.ratelimiter.service;

import com.company.ratelimiter.dto.RateLimitResponseDto;

public interface RateLimiterService {

    RateLimitResponseDto checkRateLimit(String clientId,
                                        String endpoint);
}