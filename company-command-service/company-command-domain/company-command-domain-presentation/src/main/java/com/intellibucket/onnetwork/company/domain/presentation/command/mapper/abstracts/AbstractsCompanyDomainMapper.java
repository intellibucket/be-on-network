package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts;

import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;

public interface AbstractsCompanyDomainMapper {
    CompanyRoot toNewCompanyRoot(CompanyRegistrationPayload payload);

}
