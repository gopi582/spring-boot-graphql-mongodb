package com.gateway.service;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GateWayConfig {
	
	@Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("loginModule", r -> r.path("/login/**")
                        .uri("lb://login-update-password-service")
                )
                .route("userModule", r -> r.path("/user/**")
                        .uri("lb://user-service")
                ).build();
    }

}
