package az.rock.auth.domain.presentation.config;

import az.rock.lib.AbstractPasswordEncryptor;
import az.rock.lib.GPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class AuthDomainPresentationBeanConfig {

    @Bean
    @Scope("prototype")
    public AbstractPasswordEncryptor abstractPasswordEncryptor() {
        return new GPasswordEncryptor();
    }
}
