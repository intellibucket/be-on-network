package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import com.intellibucket.lib.event.create.CompanyEmailCreateEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyEmailCreateCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyEmailHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyEmailCommandHandler implements AbstractCreateCompanyEmailHandler {
    @Override
    public CompanyEmailCreateEvent create(CompanyEmailCreateCommand companyEmailCreateCommand) {
        return null;
    }
}
