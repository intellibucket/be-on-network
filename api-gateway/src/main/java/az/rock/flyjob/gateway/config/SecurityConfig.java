package az.rock.flyjob.gateway.config;

import az.rock.spring.security.core.JwtConfig;
import az.rock.spring.security.core.JwtService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class SecurityConfig {

    private final String secretKey;
    private final Long expirationTime;

    public SecurityConfig(@Value(value = "${ws.values.security-key}") String secretKey,
                          @Value(value = "${ws.values.token-exp-time}") Long expirationTime) {
        this.secretKey = secretKey;
        this.expirationTime = expirationTime;
    }

    @Bean
    @Lazy
    public JwtConfig jwtConfig() {
        return JwtConfig.Builder
                .builder()
                .secret(this.secretKey)
                .expiration(this.expirationTime)
                .build();
    }

    ;

    @Bean
    @Lazy
    public JwtService jwtService(JwtConfig jwtConfig) {
        return new JwtService(jwtConfig);
    }

}
