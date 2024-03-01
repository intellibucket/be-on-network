package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyWebsiteCreatedCommand;

@InputPort
public interface AbstractCompanyWebsiteCommandDomainPresentationService {
    void createWebsiteByCompany(CompanyWebsiteCreatedCommand command) ;
    void changeWebsiteByCompany(CompanyWebsiteCreatedCommand command) ;
    void deleteWebsiteCompany();
}
