package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractCreateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractUpdateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyEmailCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@InputPort
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
         this.createCompanyEmailHandler.create(request);
    }

    @Override
    public void changeEmailCompany(CompanyEmailChangedCommand request) {
        this.updateCompanyEmailHandler.changeEmail(request);
    }
}
