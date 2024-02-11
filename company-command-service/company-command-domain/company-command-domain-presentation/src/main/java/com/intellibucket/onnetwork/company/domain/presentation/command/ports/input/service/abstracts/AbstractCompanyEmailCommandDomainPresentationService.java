package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts;

import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;

public interface AbstractCompanyEmailCommandDomainPresentationService {
    void createEmailCompany(CompanyEmailCreatedCommand request);
    void changeEmailCompany(CompanyEmailChangedCommand request);


}
