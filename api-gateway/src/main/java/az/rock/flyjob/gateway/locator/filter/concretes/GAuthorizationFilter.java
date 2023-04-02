package az.rock.flyjob.gateway.locator.filter.concretes;

import az.rock.flyjob.gateway.locator.filter.abstracts.AbstractGAuthorizationFilter;
import az.rock.lib.jresponse.response.fail.JFailResponse;
import az.rock.lib.util.constant.HeaderConstant;
import az.rock.lib.util.constant.LangConstant;
import az.rock.message.MessageProvider;
import az.rock.spring.security.core.JwtService;
import az.rock.spring.security.model.ClaimModel;
import az.rock.spring.security.model.HeaderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.nio.charset.StandardCharsets;

@Component
@Slf4j
public class GAuthorizationFilter extends AbstractGAuthorizationFilter {

    private final MessageProvider messageProvider;
    private final JwtService jwtService;

    public GAuthorizationFilter(MessageProvider messageProvider, JwtService jwtService) {
        this.messageProvider = messageProvider;
        this.jwtService = jwtService;
    }

    @Override
    public GatewayFilter apply(Config config) {
        log.debug("Api Gateway authorization filter executed");
        return ((exchange, chain) -> {
            try {
                var exchangeRequest = exchange.getRequest();
                HeaderModel headerModel = HeaderModel
                        .decorator()
                        .decorate(exchangeRequest);
                if (!this.checkHeaderModel(headerModel))
                    return this.fail(exchange, HttpStatus.UNAUTHORIZED, headerModel.getLang());
                var claimModel = ClaimModel.of(this.jwtService.getClaims(headerModel.getToken(), headerModel.getEncodedUserRequestPrivateKey()));
                ServerHttpRequest modifiedRequest = this.modifyRequestHeader(exchange, claimModel);
                return chain.filter(exchange.mutate().request(modifiedRequest).build());
            } catch (Exception e) {
                return this.fail(exchange, HttpStatus.BAD_REQUEST, LangConstant.EN);
            }
        });
    }


    private ServerHttpRequest modifyRequestHeader(ServerWebExchange exchange, ClaimModel claimModel) {
        return exchange
                .getRequest()
                .mutate()
                .header(HeaderConstant.UUID, claimModel.getUserUUID().toString())
                .header(HeaderConstant.USERNAME, claimModel.getUsername())
                .header(HeaderConstant.USER_PRIVATE_KEY, claimModel.getUserPrivateKey())
                .header(HeaderConstant.ROLE, claimModel.getRoleNames().toArray(String[]::new))
                .header(HeaderConstant.PERMISSIONS, claimModel.getPermissions().toArray(String[]::new))
                .header(HeaderConstant.IP_ADDRESS, claimModel.getIpAddress())
                .build();
    }

    private Boolean checkHeaderModel(HeaderModel headerModel) {
        return this.jwtService.validateToken(headerModel) && headerModel.isAvailable();
    }

    private Mono<Void> fail(ServerWebExchange serverWebExchange, HttpStatus httpStatus, String lang) {
        ServerHttpResponse serverHttpResponse = serverWebExchange.getResponse();
        serverHttpResponse.setStatusCode(httpStatus);
        serverHttpResponse.getHeaders().setContentType(MediaType.APPLICATION_JSON);
        var failResponse = new JFailResponse(this.messageProvider.fail("F_0000000003", lang));
        DataBuffer buffer = serverHttpResponse.bufferFactory().wrap(failResponse.toString().getBytes(StandardCharsets.UTF_8));
        return serverHttpResponse.writeWith(Flux.just(buffer)).then(serverHttpResponse.setComplete());
    }
}
