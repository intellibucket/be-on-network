package az.rock.flujob.gateway.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value(value = "${ws.values.security-key}")
    private String encryptKey;
    @Value(value = "${ws.values.token-exp-time}")
    private String tokenExpDate;


}
