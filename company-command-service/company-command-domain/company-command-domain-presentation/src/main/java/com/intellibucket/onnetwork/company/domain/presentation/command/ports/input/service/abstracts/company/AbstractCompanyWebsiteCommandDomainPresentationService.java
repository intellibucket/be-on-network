package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCommand;

@InputPort
public interface AbstractCompanyWebsiteCommandDomainPresentationService {
    void createWebsiteByCompany(CompanyWebsiteCommand command) ;
    void changeWebsiteByCompany(CompanyWebsiteCommand command) ;
    void deleteWebsiteCompany();
}
