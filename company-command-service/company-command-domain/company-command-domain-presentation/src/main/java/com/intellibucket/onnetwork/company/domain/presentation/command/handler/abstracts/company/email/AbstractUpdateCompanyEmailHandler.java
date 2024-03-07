package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email;

import com.intellibucket.lib.event.create.email.CompanyEmailDeletedEvent;
import com.intellibucket.lib.event.create.email.CompanyEmailUpdatedEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractUpdateCompanyEmailHandler {

    CompanyEmailUpdatedEvent changeEmailCompany(CompanyEmailChangedCommand companyEmailChangedCommand);

    CompanyEmailDeletedEvent deleteEmailCompany(UUID emailUUID);

    CompanyEmailUpdatedEvent setPrimaryEmail(UUID emailUUID);


}
