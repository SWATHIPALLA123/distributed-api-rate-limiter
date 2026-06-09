package com.company.ratelimiter.dto;

import lombok.Data;

@Data
public class RateLimitRequestDto {

    private String clientId;

    private String endpoint;
}