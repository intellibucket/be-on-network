package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCreateCompanyCommandHandler {
    void createCompany(CompanyRegistrationPayload payload);
}
