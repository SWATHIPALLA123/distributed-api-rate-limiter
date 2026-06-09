package com.company.ratelimiter.monitoring;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RequestLogger {

    public void logRequest(String clientId,
                           String endpoint) {

        log.info(
                "Request received from {} for {}",
                clientId,
                endpoint
        );
    }
}