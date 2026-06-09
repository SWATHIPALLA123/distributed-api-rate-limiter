package com.company.ratelimiter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RateLimitConfig {

    private String id;

    private String endpoint;

    private Integer maxRequests;

    private Long windowSizeInSeconds;
}