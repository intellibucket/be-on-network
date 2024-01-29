package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyEmailCreateCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyEmailCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@InputPort
@Slf4j
public class CompanyEmailCommandDomainPresentationService implements AbstractCompanyEmailCommandDomainPresentationService {

    private final AbstractCreateCompanyEmailHandler createCompanyEmailHandler;

    private final AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter;

    public CompanyEmailCommandDomainPresentationService(AbstractCreateCompanyEmailHandler createCompanyEmailHandler,
                                                        AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter) {
        this.createCompanyEmailHandler = createCompanyEmailHandler;
        this.companyCommandRepositoryAdapter = companyCommandRepositoryAdapter;
    }


    @Override
    public void createEmailCompany(CompanyEmailCreateCommand request) {

    }
}
