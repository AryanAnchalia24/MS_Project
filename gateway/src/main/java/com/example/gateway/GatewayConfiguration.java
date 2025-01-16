package com.example.gateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("productapp_route", r -> r.path("/productapp/**")
                        .uri("lb://productapp")) // The URI is dynamically resolved via Eureka (load balancing)
                .route("cartapp", r -> r.path("/carts/**")
                        .uri("lb://cartapp")) // The URI is dynamically resolved via Eureka (load balancing)
                .build();
    }
}
