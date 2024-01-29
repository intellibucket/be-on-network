package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts;

import az.rock.lib.jexception.JDomainException;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyEmailCreateCommand;

public interface AbstractCompanyEmailCommandDomainPresentationService {
    void createEmailCompany(CompanyEmailCreateCommand request);


}
