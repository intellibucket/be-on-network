package com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts;

import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.website.CompanyWebsiteCommand;

public interface AbstractCompanyWebsiteDomainMapper {
    WebsiteRoot toNewCompanyWebsiteRoot(CompanyWebsiteCommand companyWebsiteChangedCommand, CompanyID companyID);
    WebsiteRoot mapToWebsiteRoot(WebsiteRoot oldWebsiteRoot, CompanyWebsiteCommand companyWebsiteChangedCommand);

}
