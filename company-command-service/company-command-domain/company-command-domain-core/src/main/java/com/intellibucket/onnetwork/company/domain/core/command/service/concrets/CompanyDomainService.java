package com.intellibucket.onnetwork.company.domain.core.command.service.concrets;

import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyDomainService;

public class CompanyDomainService implements AbstractsCompanyDomainService {
    @Override
    public CompanyRoot fillNameAndDescription(CompanyRoot companyRoot, String name, String description) {
        companyRoot.fillNameAndDescription(name,description);
        return companyRoot;
    }
}
