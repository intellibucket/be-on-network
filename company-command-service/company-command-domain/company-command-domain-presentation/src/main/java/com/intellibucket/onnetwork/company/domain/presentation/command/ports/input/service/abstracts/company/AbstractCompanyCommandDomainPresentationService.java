package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company;

import az.rock.lib.annotation.InputPort;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.event.abstracts.AbstractSuccessDomainEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import org.springframework.transaction.annotation.Transactional;

@InputPort
public interface AbstractCompanyCommandDomainPresentationService {
    AbstractSuccessDomainEvent<?> createCompany(CompanyRegistrationPayload request) throws JDomainException;

//    void deleteCompany(CompanyID id);

    void filled(CompanyFilledCommand companyFilledCommand);
}
