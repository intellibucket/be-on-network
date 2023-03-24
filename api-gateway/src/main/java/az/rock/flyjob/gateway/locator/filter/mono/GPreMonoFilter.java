package az.rock.flyjob.gateway.locator.filter.mono;

import az.rock.lib.util.constant.HeaderConstant;
import az.rock.lib.util.constant.LangConstant;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.Objects;


@Component
@Slf4j
public class GPreMonoFilter implements GlobalFilter {

    @Value(value = "${ws.values.gateway.header-key}")
    private String gatewayKey;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("GPreMonoFilter started");
        var request = exchange.getRequest();
        var requestHeaders = request.getHeaders();
        request.mutate()
                .header(HeaderConstant.GATEWAY_KEY, this.gatewayKey)
                .header(HeaderConstant.IP_ADDRESS, this.ipAddress(request))
                .header(HeaderConstant.LANG, this.lang(request))
                .build();
        String requestPath = request.getPath().toString();
        log.info("GPreMonoFilter executed Path : {}", requestPath);
        return chain.filter(exchange.mutate().request(request).build());
    }

    private String lang(ServerHttpRequest request) {
        var langList = request.getHeaders().get(HeaderConstant.LANG);
        if (Objects.isNull(langList) || langList.isEmpty())
            return LangConstant.EN;
        else return langList.get(0);
    }

    private String ipAddress(ServerHttpRequest request) {
        return Objects.requireNonNullElse(Objects.requireNonNull(request.getRemoteAddress()).getHostName(), HeaderConstant.UNEXPECTED);
    }
}