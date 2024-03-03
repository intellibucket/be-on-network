package com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.concretes.company;

import az.rock.lib.valueObject.Switch;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileDeletedEvent;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileUpdatedEvent;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.AbstractCompanyProfileCommandHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.input.service.abstracts.company.AbstractCompanyProfileCommandDomainPresentationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class CompanyProfileCommandDomainPresentationService implements AbstractCompanyProfileCommandDomainPresentationService {
    private final AbstractCompanyProfileCommandHandler companyProfileHandler;

    public CompanyProfileCommandDomainPresentationService(AbstractCompanyProfileCommandHandler companyProfileHandler) {
        this.companyProfileHandler = companyProfileHandler;
    }

    @Override
    public void changeHiringStatus(Switch switcher) {
        CompanyProfileUpdatedEvent event = this.companyProfileHandler.changeHiringStatus(switcher);
    }

    @Override
    public void deleteCompanyProfile() {
        CompanyProfileDeletedEvent event = this.companyProfileHandler.deleteCompanyProfile();
    }

}
