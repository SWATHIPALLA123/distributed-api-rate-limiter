package com.company.ratelimiter.monitoring;

import org.springframework.stereotype.Service;

import java.util.concurrent.atomic.AtomicLong;

@Service
public class MetricsService {

    private final AtomicLong totalRequests =
            new AtomicLong();

    private final AtomicLong blockedRequests =
            new AtomicLong();

    public void incrementTotalRequests() {
        totalRequests.incrementAndGet();
    }

    public void incrementBlockedRequests() {
        blockedRequests.incrementAndGet();
    }

    public long getTotalRequests() {
        return totalRequests.get();
    }

    public long getBlockedRequests() {
        return blockedRequests.get();
    }
}