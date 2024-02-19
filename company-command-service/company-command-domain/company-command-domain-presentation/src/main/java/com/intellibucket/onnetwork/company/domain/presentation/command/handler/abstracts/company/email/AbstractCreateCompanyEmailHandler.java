package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email;

import com.intellibucket.lib.event.create.email.CompanyEmailCreatedEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCreateCompanyEmailHandler {

    CompanyEmailCreatedEvent createEmailCompany(CompanyEmailCreatedCommand companyEmailChangedCommand);

}
