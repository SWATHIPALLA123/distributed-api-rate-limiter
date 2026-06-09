package com.company.ratelimiter.controller;

import com.company.ratelimiter.dto.RateLimitResponseDto;
import com.company.ratelimiter.service.RateLimiterService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ProductController {

    private final RateLimiterService rateLimiterService;

    @GetMapping("/api/products")
    public RateLimitResponseDto getProducts(
            @RequestHeader("client-id") String clientId) {

        return rateLimiterService.checkRateLimit(
                clientId,
                "/api/products"
        );
    }
}