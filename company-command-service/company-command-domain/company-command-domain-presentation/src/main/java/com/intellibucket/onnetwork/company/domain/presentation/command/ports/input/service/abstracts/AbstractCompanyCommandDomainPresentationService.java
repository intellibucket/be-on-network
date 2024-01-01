package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts;

import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;

public interface AbstractCompanyCommandDomainPresentationService {
    void createCompany(CompanyRegistrationPayload request) throws JDomainException;

    void deleteCompany(CompanyID id);
}
