package com.intellibucket.onnetwork.company.domain.core.command.service.concrets;

import com.intellibucket.onnetwork.company.domain.core.command.exception.EmailAlreadyExistException;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyEmailDomainService;

import java.util.List;

public class CompanyEmailDomainService implements AbstractsCompanyEmailDomainService {
    @Override
    public void validateMaxEmailCount(List<EmailRoot> emailRootList) {
        if (emailRootList.size() > 3) throw new RuntimeException("F0000000005");
        //TODO RuntimeException veririk?
    }

    @Override
    public void validateForChangeEmail(EmailRoot existingEmail, EmailRoot newEmail) {
        if (existingEmail == null) throw new EmailAlreadyExistException();
        if (existingEmail.getEmail().equals(newEmail.getEmail())) throw new EmailAlreadyExistException();
    }
}
