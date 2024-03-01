package com.intellibucket.onnetwork.company.domain.core.command.service.concrets;

import com.intellibucket.onnetwork.company.domain.core.command.exception.IsSameException;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.WebsiteRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractCompanyWebsiteDomainService;

public class CompanyWebsiteDomainService implements AbstractCompanyWebsiteDomainService {
    @Override
    public void validateIsSameWebsite(WebsiteRoot websiteRoot, String newWebsite) {
        if(websiteRoot.getWebsite().equals(newWebsite)){
            throw new IsSameException("F0000000010");
        }
    }

}
