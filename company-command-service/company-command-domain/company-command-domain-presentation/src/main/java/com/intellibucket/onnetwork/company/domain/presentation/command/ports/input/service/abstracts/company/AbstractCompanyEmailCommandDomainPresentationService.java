package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company;

import az.rock.lib.annotation.InputPort;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
public interface AbstractCompanyEmailCommandDomainPresentationService {
    void createEmailCompany(CompanyEmailCreatedCommand request);
    void changeEmailCompany(CompanyEmailChangedCommand request);
    void deleteEmailCompany(UUID emailUUID);
    void setPrimaryEmail(UUID emailUUID);


}
