package com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company;

import az.rock.lib.valueObject.Switch;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileDeletedEvent;
import com.intellibucket.lib.event.create.companyprofile.CompanyProfileUpdatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public interface AbstractCompanyProfileCommandHandler {
    CompanyProfileUpdatedEvent changeHiringStatus(Switch switcher);

    CompanyProfileDeletedEvent deleteCompanyProfile();
}
