package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes.company;

import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCompanyWebsiteCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company.AbstractCompanyWebsiteCommandDomainPresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyWebsiteCommandDomainPresentationService implements AbstractCompanyWebsiteCommandDomainPresentationService {

    private final AbstractCompanyWebsiteCommandHandler companyWebsiteHandler;

    public CompanyWebsiteCommandDomainPresentationService(AbstractCompanyWebsiteCommandHandler companyWebsiteHandler) {
        this.companyWebsiteHandler = companyWebsiteHandler;
    }

    @Override
    public void createWebsiteByCompany(CompanyWebsiteCreatedCommand command) {
        this.companyWebsiteHandler.createWebsiteByCompany(command);
    }

    @Override
    public void changeWebsiteByCompany(CompanyWebsiteCreatedCommand command) {
        this.companyWebsiteHandler.changeWebsiteByCompany(command);
    }

    @Override
    public void deleteWebsiteCompany() {
        this.companyWebsiteHandler.deleteWebsiteCompany();
    }
}
