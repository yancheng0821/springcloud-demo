package com.example.gateway.filters;

import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class SimpleGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, org.springframework.cloud.gateway.filter.GatewayFilterChain chain) {
        // Pre-filter: 打印请求信息
        System.out.println("Global Pre-filter: Intercepted request to " + exchange.getRequest().getURI());

        // 继续过滤器链，转发请求到后端服务
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            // Post-filter: 打印响应状态码
            System.out.println("Global Post-filter: Intercepted response with status code " + exchange.getResponse().getStatusCode());
        }));
    }

    @Override
    public int getOrder() {
        return 0;  // 优先级
    }
}
