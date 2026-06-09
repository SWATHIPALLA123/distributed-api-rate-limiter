package com.company.ratelimiter.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ConfigResponseDto {

    private String endpoint;

    private Integer maxRequests;

    private Long windowSizeInSeconds;
}