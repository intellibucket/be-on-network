package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes.company;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.lib.event.create.email.CompanyEmailCreatedEvent;
import com.intellibucket.lib.event.create.email.CompanyEmailDeletedEvent;
import com.intellibucket.lib.event.create.email.CompanyEmailUpdatedEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractCreateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractUpdateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company.AbstractCompanyEmailCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Slf4j
public class CompanyEmailCommandDomainPresentationService implements AbstractCompanyEmailCommandDomainPresentationService {

    private final AbstractCreateCompanyEmailHandler createCompanyEmailHandler;
    private final AbstractUpdateCompanyEmailHandler updateCompanyEmailHandler;

    private final AbstractCompanyEmailCommandRepositoryAdapter companyEmailCommandRepositoryAdapter;

    public CompanyEmailCommandDomainPresentationService(AbstractCreateCompanyEmailHandler createCompanyEmailHandler,
                                                        AbstractUpdateCompanyEmailHandler updateCompanyEmailHandler,
                                                        AbstractCompanyEmailCommandRepositoryAdapter companyEmailCommandRepositoryAdapter) {
        this.createCompanyEmailHandler = createCompanyEmailHandler;
        this.updateCompanyEmailHandler = updateCompanyEmailHandler;
        this.companyEmailCommandRepositoryAdapter = companyEmailCommandRepositoryAdapter;
    }


    @Override
    public void createEmailCompany(CompanyEmailCreatedCommand request) {
        CompanyEmailCreatedEvent event = this.createCompanyEmailHandler.createEmailCompany(request);
    }

    @Override
    public void changeEmailCompany(CompanyEmailChangedCommand request) {
        CompanyEmailUpdatedEvent event = this.updateCompanyEmailHandler.changeEmailCompany(request);
    }

    @Override
    public void deleteEmailCompany(UUID emailUUID) {
        CompanyEmailDeletedEvent event = this.updateCompanyEmailHandler.deleteEmailCompany(emailUUID);
    }

    @Override
    public void setPrimaryEmail(UUID emailUUID) {
        CompanyEmailUpdatedEvent event =  this.updateCompanyEmailHandler.setPrimaryEmail(emailUUID);
    }
}
