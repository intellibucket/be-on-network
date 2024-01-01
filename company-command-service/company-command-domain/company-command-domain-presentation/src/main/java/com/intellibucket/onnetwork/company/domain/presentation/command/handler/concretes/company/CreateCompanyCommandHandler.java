package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyCommandHandler implements AbstractCreateCompanyCommandHandler {


    @Override
    public void createCompany(CompanyRegistrationPayload payload) {

    }
}
