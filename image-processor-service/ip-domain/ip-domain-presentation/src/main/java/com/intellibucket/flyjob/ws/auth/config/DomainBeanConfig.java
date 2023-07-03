package com.intellibucket.flyjob.ws.auth.config;

import com.intellibucket.flyjob.ws.auth.service.abstracts.AbstractProfilePictureDomainService;
import com.intellibucket.flyjob.ws.auth.service.concretes.ProfilePictureDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DomainBeanConfig {

    @Bean
    public AbstractProfilePictureDomainService abstractProfilePictureDomainService() {
        return new ProfilePictureDomainService();
    }
}
