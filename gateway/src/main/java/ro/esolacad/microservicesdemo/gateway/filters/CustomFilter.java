package ro.esolacad.microservicesdemo.gateway.filters;

import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;

public class CustomFilter extends AbstractGatewayFilterFactory<CustomFilter.Config> {

    public CustomFilter() { super(Config.class);}

    @Override
    public GatewayFilter apply(final Config config) {
        return ((exchange, chain) -> {
            ServerHttpRequest.Builder builder = exchange.getRequest().mutate();
            ServerHttpRequest build = builder.
                    header("X-CUSTOM=HEADER", "MICRO-HEADER")
                    .build();

            return chain.filter(exchange.mutate().request(builder.build()).build());
        });
    }

    public class Config {

    }
}
