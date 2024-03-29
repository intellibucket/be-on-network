package az.rock.auth.domain.presentation.config;

import az.rock.flyjob.auth.service.abstracts.*;
import az.rock.flyjob.auth.service.concretes.*;
import az.rock.lib.AbstractPasswordEncryptor;
import az.rock.lib.GPasswordEncryptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.validation.Validator;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class AuthDomainPresentationBeanConfig {

    @Bean
    public Validator validatorFactory() {
        return new LocalValidatorFactoryBean();
    }

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
        return new PasswordDomainService(this.abstractPasswordEncryptor());
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
    public AbstractFollowRelationDomainService abstractFollowDomainService() {
        return new FollowDomainService();
    }

    @Bean
    public AbstractBlockRelationDomainService abstractBlockRelationDomainService() {
        return new BlockRelationDomainService();
    }

    @Bean
    public AbstractPhoneNumberDomainService abstractPhoneNumberDomainService() {
        return new PhoneNumberDomainService();
    }

    @Bean
    public AbstractNetworkRelationDomainService abstractNetworkRelationDomainService() {
        return new NetworkRelationDomainService();
    }
}
