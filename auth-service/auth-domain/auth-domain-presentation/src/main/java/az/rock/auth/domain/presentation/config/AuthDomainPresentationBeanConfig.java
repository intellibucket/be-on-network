package az.rock.auth.domain.presentation.config;

import az.rock.flyjob.auth.service.abstracts.*;
import az.rock.flyjob.auth.service.concretes.*;
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
    public AbstractProfilePictureDomainService abstractProfilePictureDomainService(){
        return new ProfilePictureDomainService();
    }

    @Bean
    public AbstractUserSettingsDomainService abstractUserSettingsDomainService(){
        return new UserSettingsDomainService();
    }

    @Bean
    public AbstractPasswordDomainService abstractPasswordDomainService() {
        return new PasswordDomainService();
    }

    @Bean
    public AbstractUserDomainService abstractUserDomainService() {
        return new UserDomainService();
    }

    @Bean
    public AbstractEmailDomainService abstractEmailDomainService(){
        return new EmailDomainService();
    }


    @Bean
    public AbstractAccountPlanDomainService abstractAccountPlanDomainService() {
        return new AccountPlanDomainService();
    }

    @Bean
    public AbstractCoverPictureDomainService abstractCoverPictureDomainService(){
        return new CoverPictureDomainService();
    }

    @Bean
    public AbstractFollowDomainService abstractFollowDomainService(){
        return new FollowDomainService();
    }
}
