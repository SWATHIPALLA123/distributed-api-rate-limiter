package com.company.ratelimiter.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApiKey {

    private Long id;

    private String apiKey;

    private Long userId;

    private boolean active;
}