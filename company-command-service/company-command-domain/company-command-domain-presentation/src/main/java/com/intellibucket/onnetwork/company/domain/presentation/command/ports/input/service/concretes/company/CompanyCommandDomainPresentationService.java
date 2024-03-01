package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes.company;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company.AbstractCompanyCommandDomainPresentationService;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyCommandDomainPresentationService implements AbstractCompanyCommandDomainPresentationService {

    private final AbstractCreateCompanyCommandHandler createCompanyCommandHandler;

    private final AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter;

    public CompanyCommandDomainPresentationService(AbstractCreateCompanyCommandHandler createCompanyCommandHandler,
                                                   AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter) {
        this.createCompanyCommandHandler = createCompanyCommandHandler;
        this.companyCommandRepositoryAdapter = companyCommandRepositoryAdapter;
    }

    @Override
    public AbstractSuccessDomainEvent<?> createCompany(CompanyRegistrationPayload payload) throws JDomainException {
        log.info("CompanyCommandDomainPresentationService.createCompany() payload: {}", payload);
        return this.createCompanyCommandHandler.createCompany(payload);
    }

    @Override
    public void filled(CompanyFilledCommand companyFilledCommand){
        this.createCompanyCommandHandler.filled(companyFilledCommand);
    }

}
