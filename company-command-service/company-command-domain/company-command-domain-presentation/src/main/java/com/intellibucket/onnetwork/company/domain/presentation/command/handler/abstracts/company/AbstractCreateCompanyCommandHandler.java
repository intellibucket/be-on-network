package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import com.intellibucket.lib.event.create.CompanyFilledEvent;
import com.intellibucket.lib.event.create.CompanyProfileCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCreateCompanyCommandHandler {
    CompanyProfileCreatedEvent createCompany(CompanyRegistrationPayload payload);

    CompanyFilledEvent filled(CompanyFilledCommand companyFilledCommand);

}
