package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import com.intellibucket.lib.event.create.website.CompanyWebsiteCreatedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteDeletedEvent;
import com.intellibucket.lib.event.create.website.CompanyWebsiteUpdatedEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCommand;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCompanyWebsiteCommandHandler {
    CompanyWebsiteCreatedEvent createWebsiteByCompany(CompanyWebsiteCommand command) ;
    CompanyWebsiteUpdatedEvent changeWebsiteByCompany(CompanyWebsiteCommand command) ;
    CompanyWebsiteDeletedEvent deleteWebsiteCompany() ;
}
