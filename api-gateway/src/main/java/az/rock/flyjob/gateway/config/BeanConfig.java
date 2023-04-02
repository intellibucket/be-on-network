package az.rock.flyjob.gateway.config;

import az.rock.message.ClasspathReader;
import az.rock.message.MessageProvider;
import az.rock.spring.security.web.PerRequestHeaderBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Value(value = "${ws.values.security-key}")
    private String encryptKey;
    @Value(value = "${ws.values.token-exp-time}")
    private String tokenExpDate;

//    @Bean
//    public JSecurityManager jSecurityManager() {
//        return new JSecurityManager(this.messageProvider(), encryptKey, tokenExpDate);
//    }

    @Bean
    public PerRequestHeaderBuilder perRequestHeaderBuilder() {
        return new PerRequestHeaderBuilder();
    }

    @Bean
    public MessageProvider messageProvider() {
        return MessageProvider.Builder
                .builder()
                .withSuccessString(ClasspathReader.asString("message/success/api-gateway-success.json"))
                .withFailString(ClasspathReader.asString("message/fail/api-gateway-fail.json"))
                .buildString();
    }

}
