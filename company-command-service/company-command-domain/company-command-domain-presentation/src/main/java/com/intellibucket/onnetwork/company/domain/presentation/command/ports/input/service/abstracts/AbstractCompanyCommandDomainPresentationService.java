package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.trx.SagaStartedProcess;

public interface AbstractCompanyCommandDomainPresentationService {
    void createCompany(SagaStartedProcess<CompanyCreatedEvent> request);

    //void updateCompany(UpdateRequest<CompanyCommand> request);

    void deleteCompany(CompanyID id);
}
