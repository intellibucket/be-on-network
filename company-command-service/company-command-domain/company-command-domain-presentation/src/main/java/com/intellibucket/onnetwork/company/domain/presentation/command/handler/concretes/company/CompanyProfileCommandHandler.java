package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company;

import az.rock.lib.valueObject.Switch;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileDeletedEvent;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileUpdatedEvent;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileDeletedPayload;
import com.intellibucket.lib.payload.companyprofile.CompanyProfileUpdatedPayload;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyProfileDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCompanyProfileCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyProfileCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyProfileQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CompanyProfileCommandHandler implements AbstractCompanyProfileCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractCompanyProfileQueryRepositoryAdapter companyProfileQueryRepositoryAdapter;
    private final AbstractCompanyProfileCommandRepositoryAdapter companyProfileCommandRepositoryAdapter;

    private final AbstractCompanyProfileDomainService companyProfileDomainService;

    public CompanyProfileCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        AbstractCompanyProfileQueryRepositoryAdapter companyProfileQueryRepositoryAdapter,
                                        AbstractCompanyProfileCommandRepositoryAdapter
                                                companyProfileCommandRepositoryAdapter,
                                        AbstractCompanyProfileDomainService companyProfileDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.companyProfileQueryRepositoryAdapter = companyProfileQueryRepositoryAdapter;
        this.companyProfileCommandRepositoryAdapter = companyProfileCommandRepositoryAdapter;
        this.companyProfileDomainService = companyProfileDomainService;
    }

    @Override
    public CompanyProfileUpdatedEvent changeHiringStatus(Switch switcher) {
        var companyProfile = fetchCompanyProfile();
        CompanyProfileRoot profileRoot =  this.companyProfileDomainService
                                                    .validateAndChangeHiringStatus(companyProfile,switcher);
        this.companyProfileCommandRepositoryAdapter.update(profileRoot);
        return CompanyProfileUpdatedEvent.of(new CompanyProfileUpdatedPayload());
    }

    @Override
    public CompanyProfileDeletedEvent deleteCompanyProfile() {
        var companyProfile = fetchCompanyProfile();
        companyProfile.ifPresent(companyProfileRoot -> companyProfileCommandRepositoryAdapter.inActive(companyProfileRoot));
        return CompanyProfileDeletedEvent.of(new CompanyProfileDeletedPayload());
    }

    private Optional<CompanyProfileRoot> fetchCompanyProfile(){
        var companyUUID = this.securityContextHolder.currentCompany();
        var companyProfile = this.companyProfileQueryRepositoryAdapter.findCompanyProfileByCompanyId(companyUUID);
        return companyProfile;
    }

}
