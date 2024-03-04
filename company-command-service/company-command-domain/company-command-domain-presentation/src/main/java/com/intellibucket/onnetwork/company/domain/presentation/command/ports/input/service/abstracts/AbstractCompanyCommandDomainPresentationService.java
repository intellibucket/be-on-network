package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;

public interface AbstractCompanyCommandDomainPresentationService {
    AbstractSuccessDomainEvent<?> createCompany(CompanyRegistrationPayload request) throws JDomainException;

    void filled(CompanyFilledCommand companyFilledCommand);
}
