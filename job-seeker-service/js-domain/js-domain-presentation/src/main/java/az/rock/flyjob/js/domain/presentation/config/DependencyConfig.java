package az.rock.flyjob.js.domain.presentation.config;

import com.intellibucket.lib.client.abstracts.AuthorizationApi;
import com.intellibucket.lib.client.concretes.MockAuthorizationService;
import com.intellibucket.lib.client.concretes.RPCAuthorizationService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DependencyConfig {

    @Bean
    @ConditionalOnProperty(name = "conditions.authorization.level", havingValue = "rpc")
    public AuthorizationApi rpcAuthorizationApi() {
        return new RPCAuthorizationService();
    }

    @Bean
    @Primary
    @ConditionalOnProperty(name = "conditions.authorization.level", havingValue = "mock")
    public AuthorizationApi mockAuthorizationApi() {
        return new MockAuthorizationService();
    }
}
