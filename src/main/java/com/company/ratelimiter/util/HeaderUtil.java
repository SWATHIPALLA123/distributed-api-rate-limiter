package com.company.ratelimiter.util;

import jakarta.servlet.http.HttpServletResponse;

public class HeaderUtil {

    private HeaderUtil() {
    }

    public static void addRateLimitHeaders(
            HttpServletResponse response,
            long limit,
            long remaining,
            long reset) {

        response.setHeader(
                "X-RateLimit-Limit",
                String.valueOf(limit));

        response.setHeader(
                "X-RateLimit-Remaining",
                String.valueOf(remaining));

        response.setHeader(
                "X-RateLimit-Reset",
                String.valueOf(reset));
    }
}