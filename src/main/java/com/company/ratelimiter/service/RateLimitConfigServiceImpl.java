package com.company.ratelimiter.service;

import com.company.ratelimiter.dto.ConfigRequestDto;
import com.company.ratelimiter.entity.RateLimitConfig;
import com.company.ratelimiter.repository.RateLimitConfigRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class RateLimitConfigServiceImpl
        implements RateLimitConfigService {

    private final RateLimitConfigRepository repository;

    @Override
    public RateLimitConfig create(ConfigRequestDto dto) {

        RateLimitConfig config =
                new RateLimitConfig(
                        UUID.randomUUID().toString(),
                        dto.getEndpoint(),
                        dto.getMaxRequests(),
                        dto.getWindowSizeInSeconds()
                );

        repository.save(config);

        return config;
    }

    @Override
    public Map<String, RateLimitConfig> getAll() {
        return repository.findAll();
    }

    @Override
    public void delete(String endpoint) {
        repository.delete(endpoint);
    }
}