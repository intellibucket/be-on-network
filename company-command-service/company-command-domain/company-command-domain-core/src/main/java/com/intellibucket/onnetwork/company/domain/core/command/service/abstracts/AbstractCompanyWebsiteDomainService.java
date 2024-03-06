package com.intellibucket.onnetwork.company.domain.core.command.service.abstracts;

import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;

public interface AbstractCompanyWebsiteDomainService {
    void validateIsSameWebsite(WebsiteRoot websiteRoot, String newWebsite);

}
