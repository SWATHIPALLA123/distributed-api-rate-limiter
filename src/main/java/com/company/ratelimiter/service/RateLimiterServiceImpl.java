package com.company.ratelimiter.service;

import com.company.ratelimiter.algorithm.FixedWindowRateLimiter;
import com.company.ratelimiter.dto.RateLimitResponseDto;
import com.company.ratelimiter.entity.RateLimitConfig;
import com.company.ratelimiter.exception.RateLimitExceededException;
import com.company.ratelimiter.repository.RateLimitConfigRepository;
import lombok.RequiredArgsConstructor;
import com.company.ratelimiter.exception.RateLimitExceededException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RateLimiterServiceImpl implements RateLimiterService {

    private final FixedWindowRateLimiter rateLimiter;
    private final RateLimitConfigRepository configRepository;

    @Override
    public RateLimitResponseDto checkRateLimit(String clientId,
                                               String endpoint) {

        RateLimitConfig config =
                configRepository.findByEndpoint(endpoint);

        if (config == null) {
            config = new RateLimitConfig(
                    "1",
                    endpoint,
                    100,
                    60L
            );
        }

        boolean allowed =
                rateLimiter.isAllowed(
                        clientId,
                        endpoint,
                        config.getMaxRequests(),
                        config.getWindowSizeInSeconds()
                );

        if (!allowed) {
            throw new RateLimitExceededException(
                    "Rate limit exceeded"
            );
        }

        return new RateLimitResponseDto(
                true,
                config.getMaxRequests(),
                config.getWindowSizeInSeconds()
        );
    }
}