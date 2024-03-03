package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes.company;

import com.intellibucket.lib.event.create.website.CompanyWebsiteCreatedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteDeletedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteUpdatedEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteUpdatedCommand;
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
        CompanyWebsiteCreatedEvent event = this.companyWebsiteHandler.createWebsiteByCompany(command);
    }

    @Override
    public void changeWebsiteByCompany(CompanyWebsiteUpdatedCommand command) {
        CompanyWebsiteUpdatedEvent event = this.companyWebsiteHandler.changeWebsiteByCompany(command);
    }

    @Override
    public void deleteWebsiteCompany() {
        CompanyWebsiteDeletedEvent event = this.companyWebsiteHandler.deleteWebsiteCompany();
    }
}
