package com.ecy.authservice.configuration;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyExtractors;
import org.springframework.web.server.ServerWebExchange;
import org.springframework.web.server.WebFilter;
import org.springframework.web.server.WebFilterChain;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

/**
 * Author: ecyamak
 * Date: 17.07.2024
 * Time: 22:01
 */

@Slf4j
@Component
public class ServiceWebFilter implements WebFilter {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, WebFilterChain chain) {
        //exchange.getResponse().getHeaders().add("web-filter", "web-filter-test");
        return exchange.getRequest().getBody()
                .doOnEach(dataBufferSignal -> log.info("dd"))
                .then(chain.filter(exchange));
        /*
        return chain.filter(exchange)
                .doOnEach(signal ->
                        log.info("requestId: {}, ip: {}, method: {}, path :{}, headers: {}, body: {}",
                                exchange.getRequest().getId(),
                                exchange.getRequest().getLocalAddress(),
                                exchange.getRequest().getMethod(),
                                exchange.getRequest().getPath(),
                                exchange.getRequest().getHeaders()));
         */
    }

}
