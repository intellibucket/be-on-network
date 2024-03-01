package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyWebsiteCreatedCommand;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCompanyWebsiteCommandHandler {
    void createWebsiteByCompany(CompanyWebsiteCreatedCommand command) ;
    void changeWebsiteByCompany(CompanyWebsiteCreatedCommand command) ;
    void deleteWebsiteCompany() ;
}
