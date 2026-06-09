package com.company.ratelimiter.controller;

import com.company.ratelimiter.dto.RateLimitResponseDto;
import com.company.ratelimiter.service.RateLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class OrderController {

    private final RateLimiterService rateLimiterService;

    @PostMapping("/api/orders")
    public RateLimitResponseDto createOrder(
            @RequestHeader("client-id") String clientId) {

        return rateLimiterService.checkRateLimit(
                clientId,
                "/api/orders"
        );
    }
}