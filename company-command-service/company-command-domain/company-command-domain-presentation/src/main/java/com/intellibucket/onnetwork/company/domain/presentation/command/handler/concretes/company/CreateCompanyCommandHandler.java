package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import com.intellibucket.lib.event.create.CompanyFilledEvent;
import com.intellibucket.lib.event.create.CompanyProfileCreatedEvent;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.core.command.exception.NoActiveRowException;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.concrets.CompanyDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.CompanyFilledCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCreateCompanyCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractsCompanyDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyCommandHandler implements AbstractCreateCompanyCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractsCompanyDomainMapper companyDomainMapper;

    private final AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter;

    private final CompanyDomainService changeDomainService;

    private final AbstractCompanyQueryRepositoryAdapter companyQueryRepositoryAdapter;

    //TODO query cagirilmalidir

    public CreateCompanyCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                       AbstractsCompanyDomainMapper companyDomainMapper,
                                       AbstractCompanyCommandRepositoryAdapter companyCommandRepositoryAdapter,
                                       CompanyDomainService changeDomainService,
                                       AbstractCompanyQueryRepositoryAdapter companyQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.companyDomainMapper = companyDomainMapper;
        this.companyCommandRepositoryAdapter = companyCommandRepositoryAdapter;
        this.changeDomainService = changeDomainService;
        this.companyQueryRepositoryAdapter = companyQueryRepositoryAdapter;
    }

    @Override
    public CompanyProfileCreatedEvent createCompany(CompanyRegistrationPayload payload) {
        var newCompanyRoot = this.companyDomainMapper.toNewCompanyRoot(payload);
        var savedRoot = this.companyCommandRepositoryAdapter.create(newCompanyRoot);
        //TODO duzgun prosesi return et
//        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
    return null;
    }

    @Override
    public CompanyFilledEvent filled(CompanyFilledCommand companyFilledCommand) throws NoActiveRowException {
        var currentUserId = this.securityContextHolder.availableUser();
        var optionalCompanyById = this.companyQueryRepositoryAdapter.getCompanyRootByUserId(currentUserId);//this...(currentUserId.getAbsoluteID(), targetUserId);

        if (optionalCompanyById.isPresent()) {
            var companyRoot = optionalCompanyById.get();
            companyRoot = changeDomainService.fillNameAndDescription(companyRoot,
                                                       companyFilledCommand.getName(),
                                                       companyFilledCommand.getDescription());

            this.companyCommandRepositoryAdapter.update(companyRoot);
//            return CompanyFilledEvent.of(this.fromRoot(networkRelationRoot));
        }else {
            throw new NoActiveRowException();
        }
        return null;
    }
}
