package az.rock.auth.domain.presentation.config.security;

import org.springframework.beans.factory.annotation.Value;
public class SecurityConfig{

    @Value(value = "${ws.values.gateway.ip-address}")
    private String gatewayIp;

//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new Argon2PasswordEncoder(16, 32, 1, 4096, 3 );
//    }


}
