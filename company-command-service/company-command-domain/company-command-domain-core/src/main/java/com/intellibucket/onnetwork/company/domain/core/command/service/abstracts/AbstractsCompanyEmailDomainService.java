package com.intellibucket.onnetwork.company.domain.core.command.service.abstracts;

import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;

import java.util.List;

public interface AbstractsCompanyEmailDomainService {
    void validateMaxEmailCount(List<EmailRoot> emailRootList);

    void validateForChangeEmail(EmailRoot oldEmail,EmailRoot newEmail);
}
