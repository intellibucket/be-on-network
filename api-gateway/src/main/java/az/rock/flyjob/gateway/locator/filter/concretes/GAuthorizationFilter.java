package az.rock.flyjob.gateway.locator.filter.concretes;

import az.rock.flyjob.gateway.locator.filter.abstracts.AbstractGAuthorizationFilter;
import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.constant.HeaderConstant;
import az.rock.message.MessageProvider;
import az.rock.spring.security.core.JwtService;
import az.rock.spring.security.model.ClaimModel;
import az.rock.spring.security.model.HeaderModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;

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
            var exchangeRequest = exchange.getRequest();
            HeaderModel headerModel = HeaderModel
                    .decorator()
                    .decorate(exchangeRequest);
            var exception = new JSecurityException(this.messageProvider.fail("F_0000000002", headerModel.getLang()));
            if (!this.checkHeaderModel(headerModel)) throw exception;
            var claimModel = ClaimModel.of(this.jwtService.getClaims(headerModel.getToken(), headerModel.getEncodedUserRequestPrivateKey()));
            ServerHttpRequest modifiedRequest = this.modifyRequestHeader(exchange, claimModel);
            return chain.filter(exchange.mutate().request(modifiedRequest).build());
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
        return this.jwtService.validateToken(headerModel);
    }
}
