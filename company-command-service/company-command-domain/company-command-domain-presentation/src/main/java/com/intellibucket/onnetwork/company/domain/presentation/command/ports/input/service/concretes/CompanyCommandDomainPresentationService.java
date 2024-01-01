package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.AbstractCompanyCommandDomainPresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@InputPort
@Slf4j
public class CompanyCommandDomainPresentationService implements AbstractCompanyCommandDomainPresentationService {

    private final AbstractCreateCompanyCommandHandler createCompanyCommandHandler;

    public CompanyCommandDomainPresentationService(AbstractCreateCompanyCommandHandler createCompanyCommandHandler) {
        this.createCompanyCommandHandler = createCompanyCommandHandler;
    }

    @Override
    public void createCompany(CompanyRegistrationPayload payload) throws JDomainException {
        log.info("CompanyCommandDomainPresentationService.createCompany");
        this.createCompanyCommandHandler.createCompany(payload);
    }

    @Override
    public void deleteCompany(CompanyID id) {

    }

}
