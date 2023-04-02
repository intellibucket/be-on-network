package az.rock.spring.security.web;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.constant.HeaderConstant;
import az.rock.lib.util.constant.LangConstant;
import az.rock.spring.security.model.HeaderModel;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class PerRequestHeaderBuilder {

    public HeaderModel build(ServerHttpRequest serverHttpRequest) throws JSecurityException {
        var ipAddress = this.getIpAddress(serverHttpRequest);
        var lang = this.getLang(serverHttpRequest);
        var optionalPrivateKey = this.getPrivateKey(serverHttpRequest);
        var token = this.getToken(serverHttpRequest);
        return HeaderModel
                .builder()
                .withLang(lang)
                .withIpAddress(ipAddress)
                .withUserRequestPrivateKey(optionalPrivateKey)
                .withToken(token)
                .build();
    }

    private String getLang(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNullElse(serverHttpRequest.getHeaders().get(HeaderConstant.LANG), List.of(LangConstant.AZ)).get(0);
    }

    private String getPrivateKey(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNullElse(serverHttpRequest.getHeaders().get(HeaderConstant.USER_PRIVATE_KEY), List.of("")).get(0);
    }

    private String getIpAddress(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNull(serverHttpRequest.getRemoteAddress()).getAddress().getHostAddress();
    }

    private String getToken(ServerHttpRequest serverHttpRequest) {
        return Objects.requireNonNullElse(
                        serverHttpRequest.getHeaders().get(HeaderConstant.AUTHORIZATION),
                        List.of(this.generateGuestToken()))
                .get(0)
                .replace(HeaderConstant.BEARER.concat(" "), "");
    }

    private String generateGuestToken() {
        return "Guest ".concat(UUID.randomUUID().toString());
    }
}
