package org.example.apigateway.global.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Configuration
public class RateLimiterConfig {

    @Bean
    public KeyResolver ipKeyResolver() {
        // 요청을 식별하는 데 사용되는 키를 결정하는 역할
        return exchange -> Mono.just(
                Objects.requireNonNull(
                        exchange.getRequest().getRemoteAddress()
                ).getAddress().getHostAddress()
        );
    }

    // @Bean
    public KeyResolver userIdQueryParamKeyResolver() {
        // 요청을 식별하는 데 사용되는 키를 결정하는 역할
        return exchange -> Mono.just(
                Objects.requireNonNull(
                        exchange.getRequest().getQueryParams().getFirst("userId")
                )
        );
    }
}

