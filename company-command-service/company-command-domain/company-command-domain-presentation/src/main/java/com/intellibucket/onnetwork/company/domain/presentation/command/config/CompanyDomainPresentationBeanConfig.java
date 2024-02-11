package com.intellibucket.onnetwork.company.domain.presentation.command.config;

import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyEmailDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyDomainPresentationBeanConfig {

    @Bean
    public CompanyDomainService abstractCompanyDomainService(){
        return new CompanyDomainService();
    }

    @Bean
    public CompanyEmailDomainService abstractEmailDomainService(){
        return new CompanyEmailDomainService();
    }
}
