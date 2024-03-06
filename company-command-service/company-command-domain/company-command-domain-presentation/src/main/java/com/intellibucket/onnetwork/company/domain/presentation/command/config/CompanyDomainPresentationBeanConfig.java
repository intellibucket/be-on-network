package com.intellibucket.onnetwork.company.domain.presentation.command.config;

import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyProfileDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyWebsiteDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyEmailDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyEmailDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyProfileDomainService;
import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyWebsiteDomainService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CompanyDomainPresentationBeanConfig {

    @Bean
    public AbstractsCompanyDomainService abstractCompanyDomainService(){
        return new CompanyDomainService();
    }

    @Bean
    public AbstractsCompanyEmailDomainService abstractEmailDomainService(){
        return new CompanyEmailDomainService();
    }

    @Bean
    public AbstractCompanyProfileDomainService abstractCompanyProfileDomainService(){
        return new CompanyProfileDomainService();
    }

    @Bean
    public AbstractCompanyWebsiteDomainService abstractCompanyWebsiteDomainService(){
        return new CompanyWebsiteDomainService();
    }
}
