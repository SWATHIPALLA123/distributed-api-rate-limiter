# Distributed API Rate Limiter

## Overview

Distributed API Rate Limiter is a Spring Boot application that protects APIs from excessive requests by limiting the number of requests a client can make within a configurable time window.

The system uses Redis for distributed request counting and supports multiple rate-limiting algorithms. It is designed to work across multiple application instances and provides centralized rate-limit management.

---

## Features

- Fixed Window Rate Limiter
- Sliding Window Rate Limiter
- Token Bucket Rate Limiter
- Redis-based distributed counters
- Dynamic Rate Limit Configuration
- JWT Authentication
- API Key Authentication
- Global Exception Handling
- Request Monitoring and Logging
- Scheduler Support
- Swagger/OpenAPI Documentation
- MySQL Database Integration

---

## Technology Stack

- Java 17
- Spring Boot 3
- Spring Web
- Spring Security
- Spring Data JPA
- Spring Data Redis
- MySQL
- Redis
- Maven
- Lombok
- Swagger OpenAPI

---

## Architecture

Client Request
        |
        v
RateLimitInterceptor
        |
        v
RateLimiterService
        |
        v
Fixed Window / Sliding Window / Token Bucket
        |
        v
Redis Counter Storage
        |
        v
Allow / Reject Request

---

## Project Structure

src/main/java/com/company/ratelimiter

├── algorithm
│   ├── FixedWindowRateLimiter.java
│   ├── SlidingWindowRateLimiter.java
│   └── TokenBucketRateLimiter.java
│
├── config
│   ├── SwaggerConfig.java
│   └── WebMvcConfig.java
│
├── constants
│   ├── RedisKeys.java
│   └── RateLimitConstants.java
│
├── controller
│   ├── ProductController.java
│   ├── OrderController.java
│   └── RateLimitConfigController.java
│
├── dto
│   ├── RateLimitRequestDto.java
│   ├── RateLimitResponseDto.java
│   ├── ConfigRequestDto.java
│   └── ConfigResponseDto.java
│
├── entity
│   ├── User.java
│   ├── ApiKey.java
│   └── RateLimitConfig.java
│
├── exception
│   ├── GlobalExceptionHandler.java
│   ├── RateLimitExceededException.java
│   └── ResourceNotFoundException.java
│
├── interceptor
│   └── RateLimitInterceptor.java
│
├── monitoring
│   ├── MetricsService.java
│   └── RequestLogger.java
│
├── redis
│   ├── RedisConfig.java
│   ├── RedisService.java
│   └── RedisKeyGenerator.java
│
├── repository
│   ├── RedisRateLimitRepository.java
│   └── RateLimitConfigRepository.java
│
├── scheduler
│   └── CleanupScheduler.java
│
├── security
│   ├── SecurityConfig.java
│   ├── JwtAuthenticationFilter.java
│   ├── JwtTokenProvider.java
│   └── ApiKeyAuthenticationFilter.java
│
├── service
│   ├── RateLimiterService.java
│   ├── RateLimiterServiceImpl.java
│   ├── RateLimitConfigService.java
│   └── RateLimitConfigServiceImpl.java
│
├── util
│   ├── DateUtil.java
│   └── HeaderUtil.java
│
├── validator
│   └── RateLimitValidator.java
│
└── RatelimiterApplication.java

---

## REST APIs

### Products API

GET /api/products

Response:

[
  {
    "id": 1,
    "name": "Laptop",
    "price": 50000
  }
]

---

### Orders API

POST /api/orders

Request:

{
  "productId": 1,
  "quantity": 2
}

Response:

{
  "message": "Order Created Successfully"
}

---

### Create Rate Limit Configuration

POST /rate-limit/config

Request:

{
  "endpoint": "/api/products",
  "maxRequests": 100,
  "windowSizeInSeconds": 60
}

Response:

{
  "id": 1,
  "endpoint": "/api/products",
  "maxRequests": 100,
  "windowSizeInSeconds": 60
}

---

### Get All Configurations

GET /rate-limit/config

---

### Update Configuration

PUT /rate-limit/config/{id}

---

### Delete Configuration

DELETE /rate-limit/config/{id}

---

## Database Tables

### users

| Column | Type |
|----------|----------|
| id | BIGINT |
| username | VARCHAR(100) |
| email | VARCHAR(150) |
| role | VARCHAR(50) |

---

### api_keys

| Column | Type |
|----------|----------|
| id | BIGINT |
| api_key | VARCHAR(255) |
| user_id | BIGINT |

---

### rate_limit_config

| Column | Type |
|----------|----------|
| id | BIGINT |
| endpoint | VARCHAR(255) |
| max_requests | INT |
| window_size_in_seconds | BIGINT |

---

## Rate Limiting Algorithms

### Fixed Window Algorithm

- Counter stored in Redis
- Counter resets after configured time window
- Simple and efficient

### Sliding Window Algorithm

- More accurate request tracking
- Reduces burst traffic issues

### Token Bucket Algorithm

- Supports burst traffic
- Tokens generated at fixed rate
- Requests consume tokens

---

## Redis Key Design

rate_limit:user:{userId}

rate_limit:apiKey:{apiKey}

rate_limit:endpoint:{endpoint}

rate_limit:config

---

## Response Headers

X-RateLimit-Limit

X-RateLimit-Remaining

X-RateLimit-Reset

---

## Security

### JWT Authentication

Authorization: Bearer <token>

### API Key Authentication

X-API-KEY: your-api-key

---

## Exception Handling

### Rate Limit Exceeded

HTTP Status:

429 Too Many Requests

Response:

{
  "message": "Rate limit exceeded"
}

### Resource Not Found

HTTP Status:

404 Not Found

---

## Monitoring

- Request Logging
- API Usage Metrics
- Scheduler Monitoring

---

## Scheduler

CleanupScheduler automatically removes expired rate-limit records.

---

## Running Application

Clone Repository

git clone https://github.com/SWATHIPALLA123/distributed-api-rate-limiter.git

Build Project

mvn clean install

Run Application

mvn spring-boot:run

Application URL

http://localhost:8080

Swagger URL

http://localhost:8080/swagger-ui/index.html

---

## Future Enhancements

- Prometheus Metrics
- Grafana Dashboard
- Redis Cluster Support
- User Tier Based Rate Limits
- API Analytics Dashboard
- Distributed Tracing

---

## Author

Swathi Palla

Distributed API Rate Limiter using Spring Boot, Redis, MySQL, JWT Authentication, and Rate Limiting Algorithms.
