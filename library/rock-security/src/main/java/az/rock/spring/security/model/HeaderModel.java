package az.rock.spring.security.model;

import az.rock.lib.jexception.JSecurityException;
import az.rock.lib.util.constant.HeaderConstant;
import az.rock.lib.util.constant.LangConstant;
import org.springframework.http.server.reactive.ServerHttpRequest;

import java.util.Base64;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class HeaderModel {
    private final String lang;
    private final String userRequestPrivateKey;
    private final String ipAddress;
    private final String token;


    private HeaderModel(Builder builder) {
        lang = builder.lang;
        userRequestPrivateKey = builder.userRequestPrivateKey;
        ipAddress = builder.ipAddress;
        token = builder.token;
    }

    public Boolean isEmpty() {
        return this.lang.isBlank() && this.userRequestPrivateKey.isBlank() && this.ipAddress.isBlank() && this.token.isBlank();
    }

    public Boolean isAvailable() {
        return !this.isEmpty() && this.hasPrivateKey() && this.hasIpAddress() && this.isTokenAvailable();
    }

    private Boolean isTokenAvailable() {
        return !this.token.isBlank() && (this.token.startsWith(HeaderConstant.BEARER) || this.token.startsWith(HeaderConstant.GUEST));
    }

    public static Builder builder() {
        return new Builder();
    }

    public static Decorator decorator() {
        return new Decorator();
    }

    public String getLang() {
        return lang;
    }

    public String getUserRequestPrivateKey() {
        return userRequestPrivateKey;
    }

    public String getEncodedUserRequestPrivateKey() {
        return Base64.getEncoder().encodeToString(this.userRequestPrivateKey.getBytes());
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getToken() {
        return !this.isGuest() ? this.token : this.token.replace("Guest ", "");
    }

    public Boolean isGuest() {
        return this.token.startsWith("Guest");
    }

    public Boolean isUser() {
        return !this.isGuest();
    }

    public Boolean hasPrivateKey() {
        return !this.userRequestPrivateKey.isBlank();
    }

    public Boolean hasIpAddress() {
        return !this.ipAddress.isBlank();
    }

    public static final class Decorator {

        public HeaderModel decorate(ServerHttpRequest serverHttpRequest) throws JSecurityException {
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

    public static final class Builder {
        private String lang;
        private String userRequestPrivateKey;
        private String ipAddress;
        private String token;
        private String unauthorizedMessage;

        private Builder() {
        }

        public Builder withLang(String lang) {
            this.lang = lang;
            return this;
        }

        public Builder withUnauthorizedMessage(String message) {
            this.unauthorizedMessage = message;
            return this;
        }

        public Builder withUserRequestPrivateKey(String userRequestPrivateKey) {
            this.userRequestPrivateKey = userRequestPrivateKey;
            return this;
        }

        public Builder withIpAddress(String ipAddress) {
            this.ipAddress = ipAddress;
            return this;
        }

        public Builder withToken(String token) {
            this.token = token;
            return this;
        }

        public HeaderModel build() {
            if (this.unauthorizedMessage == null)
                unauthorizedMessage = "Unauthorized request";
            return new HeaderModel(this);
        }
    }


}
