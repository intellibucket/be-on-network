package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import com.intellibucket.lib.event.create.CompanyProfileCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractsCompanyDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyCommandHandler implements AbstractCreateCompanyCommandHandler {

    private final AbstractsCompanyDomainMapper companyDomainMapper;

    private final AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter;

    public CreateCompanyCommandHandler(AbstractsCompanyDomainMapper companyDomainMapper, AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter) {
        this.companyDomainMapper = companyDomainMapper;
        this.companyCommandRepositoryAdapter = companyCommandRepositoryAdapter;
    }

    @Override
    public CompanyProfileCreatedEvent createCompany(CompanyRegistrationPayload payload) {
        var newCompanyRoot = this.companyDomainMapper.toNewCompanyRoot(payload);
        var savedRoot = this.companyCommandRepositoryAdapter.create(newCompanyRoot);
        //TODO duzgun prosesi return et
//        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
    return null;
    }
}
