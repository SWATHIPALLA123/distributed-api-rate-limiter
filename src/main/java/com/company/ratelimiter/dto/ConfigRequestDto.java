package com.company.ratelimiter.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class ConfigRequestDto {

    @NotBlank
    private String endpoint;

    @Min(1)
    private Integer maxRequests;

    @Min(1)
    private Long windowSizeInSeconds;
}