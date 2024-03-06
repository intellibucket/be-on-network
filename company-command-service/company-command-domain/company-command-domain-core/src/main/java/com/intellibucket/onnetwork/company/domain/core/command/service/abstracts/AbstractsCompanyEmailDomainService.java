package com.intellibucket.onnetwork.company.domain.core.command.service.abstracts;


import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;

import java.util.List;
import java.util.UUID;

public interface AbstractsCompanyEmailDomainService {
    void validateMaxEmailCount(List<EmailRoot> emailRootList);
    void validateForChangeEmail(List<EmailRoot> emailRootList,EmailRoot newEmail);
    void validateForDeleteEmail(CompanyID companyID, EmailRoot emailRoot);
    void validateIfEmailIsPrimary(List<EmailRoot> emailRootList, UUID emailUUID);
}
