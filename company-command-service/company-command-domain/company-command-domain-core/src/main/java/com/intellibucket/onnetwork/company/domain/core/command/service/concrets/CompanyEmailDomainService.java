package com.intellibucket.onnetwork.company.domain.core.command.service.concrets;

import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.domain.id.company.CompanyID;
import com.intellibucket.onnetwork.company.domain.core.command.exception.AccessDeniedDomainException;
import com.intellibucket.onnetwork.company.domain.core.command.exception.email.CompanyEmailMaxCountException;
import com.intellibucket.onnetwork.company.domain.core.command.exception.email.EmailAlreadyExistException;
import com.intellibucket.onnetwork.company.domain.core.command.exception.email.EmailAlreadyPrimaryException;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyEmailDomainService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.Boolean.TRUE;

public class CompanyEmailDomainService implements AbstractsCompanyEmailDomainService {
    @Override
    public void validateMaxEmailCount(List<EmailRoot> emailRootList) {
        if (emailRootList.size() > 3) throw new CompanyEmailMaxCountException();
    }

    @Override
    public void validateForChangeEmail(List<EmailRoot> emailRootList, EmailRoot newEmail) {
        emailRootList.stream()
                .filter(emailRoot -> emailRoot.getEmail().equals(newEmail.getEmail()))
                .findAny()
                .ifPresent(emailRoot -> {
                    throw new EmailAlreadyExistException();
                });
    }


    public void validateForDeleteEmail(CompanyID companyID, EmailRoot emailRoot) {
        if (!emailRoot.isOwned(companyID)) throw new AccessDeniedDomainException();
    }

    @Override
    public void validateIfEmailIsPrimary(List<EmailRoot> emailRootList, UUID emailUUID) {

        emailRootList.stream()
                .filter(emailRoot -> emailRoot.getRootID().equals(emailUUID))
                .filter(emailRoot -> emailRoot.getIsPrimary().equals(TRUE))
                .findFirst()
                .ifPresent(emailRoot -> {
                    throw new EmailAlreadyPrimaryException();
                });

    }


}
