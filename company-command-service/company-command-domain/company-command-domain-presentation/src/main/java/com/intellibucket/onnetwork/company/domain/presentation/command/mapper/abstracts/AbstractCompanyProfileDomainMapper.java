package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.lib.payload.payload.reg.CompanyRegistrationPayload;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyProfileRoot;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.CompanyRoot;

import java.util.UUID;

public interface AbstractCompanyProfileDomainMapper{
    CompanyProfileRoot toNewCompanyProfileRoot(CompanyID companyUUID);
}
