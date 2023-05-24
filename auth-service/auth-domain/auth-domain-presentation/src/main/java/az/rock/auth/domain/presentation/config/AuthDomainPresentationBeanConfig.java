package az.rock.auth.domain.presentation.config;

import az.rock.flyjob.auth.service.abstracts.AbstractAuthorityDomainService;
import az.rock.flyjob.auth.service.abstracts.AbstractDetailDomainService;
import az.rock.flyjob.auth.service.abstracts.AbstractPasswordDomainService;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.flyjob.auth.service.concretes.AuthorityDomainService;
import az.rock.flyjob.auth.service.concretes.DetailDomainService;
import az.rock.flyjob.auth.service.concretes.PasswordDomainService;
import az.rock.flyjob.auth.service.concretes.UserDomainService;
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

    @Bean
    public AbstractAuthorityDomainService abstractAuthorityDomainService() {
        return new AuthorityDomainService();
    }

    @Bean
    public AbstractDetailDomainService abstractDetailDomainService() {
        return new DetailDomainService();
    }

    @Bean
    public AbstractPasswordDomainService abstractPasswordDomainService() {
        return new PasswordDomainService();
    }

    @Bean
    public AbstractUserDomainService abstractUserDomainService() {
        return new UserDomainService();
    }
}
