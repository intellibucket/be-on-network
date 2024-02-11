package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;

public interface AbstractCompanyEmailDomainMapper {
    EmailRoot toNewCompanyEmailRoot(CompanyEmailCreatedCommand companyEmailChangedCommand, CompanyID companyUuid);

    EmailRoot mapToEmailRoot(EmailRoot oldEmail, CompanyEmailChangedCommand companyEmailChangedCommand);

}
