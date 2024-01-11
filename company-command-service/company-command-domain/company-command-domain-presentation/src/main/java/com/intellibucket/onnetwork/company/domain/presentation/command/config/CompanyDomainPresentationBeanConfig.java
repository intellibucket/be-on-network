package com.intellibucket.onnetwork.company.domain.presentation.command.config;

import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyDomainPresentationBeanConfig {

    @Bean
    public CompanyDomainService abstractEmailDomainService(){
        return new CompanyDomainService();
    }
}
