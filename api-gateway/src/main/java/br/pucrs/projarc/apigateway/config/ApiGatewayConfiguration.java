package br.pucrs.projarc.apigateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

    @Bean
    public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p.path("/rotas/**").uri("lb://scta"))
                .route(p -> p.path("/aerovias/**").uri("lb://scta"))
                .route(p -> p.path("/planos-de-voo/**").uri("lb://scta"))
                .route(p -> p.path("/plano-de-voo/**").uri("lb://flight-plan"))
                .build();
    }
}