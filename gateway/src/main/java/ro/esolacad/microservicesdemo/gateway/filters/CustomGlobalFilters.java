package ro.esolacad.microservicesdemo.gateway.filters;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

//@Configuration
public class CustomGlobalFilters {

    private static final Logger LOG = LoggerFactory.getLogger(CustomGlobalFilters.class);

//    @Bean
    public GlobalFilter customGlobalFilter() {
        return new GlobalFilter() {
            @Override
            public Mono<Void> filter(final ServerWebExchange exchange, final GatewayFilterChain chain) {
                LOG.info(String.format("Method %s and uri %s",
                        exchange.getRequest().getMethod(),
                        exchange.getRequest().getURI()
                        )
                );

                return chain.filter(exchange);
            }
        };
    }

//    @Bean
    public GlobalFilter customGlobalPostFilter() {
        return (exchange, chain) -> chain.filter(exchange)
                .then(Mono.just(exchange))
                .map(serverWebExchange -> {

                    serverWebExchange.getResponse().getHeaders().set("CUSTOM-RESPONSE-HEADER",
                            HttpStatus.OK.equals(serverWebExchange.getResponse().getStatusCode()) ? "E ok" : "Nu e ok");
                    return serverWebExchange;

                }).then();
    }
}
