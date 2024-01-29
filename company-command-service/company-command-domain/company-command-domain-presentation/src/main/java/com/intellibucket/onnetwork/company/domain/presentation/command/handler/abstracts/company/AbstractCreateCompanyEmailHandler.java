package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import com.intellibucket.lib.event.create.CompanyEmailCreateEvent;
import com.intellibucket.lib.event.create.CompanyFilledEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyEmailCreateCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCreateCompanyEmailHandler {

    CompanyEmailCreateEvent create(CompanyEmailCreateCommand companyEmailCreateCommand);

}
