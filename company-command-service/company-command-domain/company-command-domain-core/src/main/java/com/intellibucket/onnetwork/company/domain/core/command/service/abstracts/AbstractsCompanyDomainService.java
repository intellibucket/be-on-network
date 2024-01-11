package com.intellibucket.onnetwork.company.domain.core.command.service.abstracts;

import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;

public interface AbstractsCompanyDomainService {

    CompanyRoot fillNameAndDescription(CompanyRoot companyRoot, String name, String description);
}
