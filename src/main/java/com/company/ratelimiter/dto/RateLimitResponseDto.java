package com.company.ratelimiter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RateLimitResponseDto {

    private boolean allowed;

    private long remainingRequests;

    private long resetTime;
}