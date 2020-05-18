package ro.esolacad.microservicesdemo.gateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class RoutesConfig {

//    @Bean
    public RouteLocator gatewayRoutes(final RouteLocatorBuilder builder) {
        return builder
                .routes()
                    .route(pred ->
                            pred.path("/inventory/**")
                            .and().weight("group1", 8)
                            .filters(f -> f.stripPrefix(1))
                            .uri("http://localhost:8080"))

                    .route(pred ->
                            pred.path("/inventory/**")
                        .and().weight("group1", 2)
                        .filters(f -> f.stripPrefix(1))
                        .uri("http://localhost:8081"))

                    .build();
    }
}
