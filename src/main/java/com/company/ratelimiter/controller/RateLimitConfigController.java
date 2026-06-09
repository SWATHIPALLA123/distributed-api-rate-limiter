package com.company.ratelimiter.controller;

import com.company.ratelimiter.dto.ConfigRequestDto;
import com.company.ratelimiter.entity.RateLimitConfig;
import com.company.ratelimiter.service.RateLimitConfigService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rate-limit/config")
@RequiredArgsConstructor
public class RateLimitConfigController {

    private final RateLimitConfigService service;

    @GetMapping
    public Map<String, RateLimitConfig> getAll() {
        return service.getAll();
    }

    @PostMapping
    public RateLimitConfig create(
            @Valid @RequestBody ConfigRequestDto dto) {

        return service.create(dto);
    }

    @DeleteMapping("/{endpoint}")
    public void delete(
            @PathVariable String endpoint) {

        service.delete(endpoint);
    }
}