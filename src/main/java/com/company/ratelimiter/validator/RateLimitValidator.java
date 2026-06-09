package com.company.ratelimiter.validator;

import org.springframework.stereotype.Component;

@Component
public class RateLimitValidator {

    public boolean isValid(String clientId,
                           String endpoint) {

        return clientId != null
                && !clientId.isBlank()
                && endpoint != null
                && !endpoint.isBlank();
    }
}