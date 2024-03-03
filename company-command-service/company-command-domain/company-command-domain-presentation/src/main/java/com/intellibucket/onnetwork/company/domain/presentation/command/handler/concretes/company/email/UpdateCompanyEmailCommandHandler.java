package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company.email;

import az.rock.lib.domain.id.auth.EmailID;
import az.rock.lib.domain.id.company.CompanyID;
import az.rock.lib.jexception.NoActiveRowException;
import com.intellibucket.lib.event.create.email.CompanyEmailDeletedEvent;
import com.intellibucket.lib.event.create.email.CompanyEmailUpdatedEvent;
import com.intellibucket.lib.payload.email.CompanyEmailDeletedPayload;
import com.intellibucket.lib.payload.email.CompanyEmailUpdatedPayload;
import com.intellibucket.onnetwork.company.domain.core.command.root.company.EmailRoot;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyEmailDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractUpdateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyEmailDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyEmailQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class UpdateCompanyEmailCommandHandler implements AbstractUpdateCompanyEmailHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractCompanyEmailQueryRepositoryAdapter companyEmailQueryRepositoryAdapter;
    private final AbstractCompanyEmailCommandRepositoryAdapter companyEmailCommandRepositoryAdapter;
    private final AbstractsCompanyEmailDomainService companyEmailDomainService;
    private final AbstractCompanyEmailDomainMapper companyEmailDomainMapper;

    public UpdateCompanyEmailCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                            AbstractCompanyEmailQueryRepositoryAdapter companyEmailQueryRepositoryAdapter,
                                            AbstractCompanyEmailCommandRepositoryAdapter companyEmailCommandRepositoryAdapter,
                                            AbstractsCompanyEmailDomainService companyEmailDomainService,
                                            AbstractCompanyEmailDomainMapper companyEmailDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.companyEmailQueryRepositoryAdapter = companyEmailQueryRepositoryAdapter;
        this.companyEmailCommandRepositoryAdapter = companyEmailCommandRepositoryAdapter;
        this.companyEmailDomainService = companyEmailDomainService;
        this.companyEmailDomainMapper = companyEmailDomainMapper;
    }


    @Override
    public CompanyEmailUpdatedEvent changeEmailCompany(CompanyEmailChangedCommand companyEmailChangedCommand) {
        var currentCompanyId = this.securityContextHolder.currentCompany();
        List<EmailRoot> allEmails = this.companyEmailQueryRepositoryAdapter.findAllEmails(currentCompanyId);
        EmailRoot findCurrentCompanyEmail =
                findCurrentCompanyEmailFromEmailList(allEmails);

        var newEmail = this.companyEmailDomainMapper.mapToEmailRoot(findCurrentCompanyEmail, companyEmailChangedCommand);
        this.companyEmailDomainService.validateForChangeEmail(allEmails, newEmail);
        this.companyEmailCommandRepositoryAdapter.update(newEmail);
        return CompanyEmailUpdatedEvent.of(new CompanyEmailUpdatedPayload());

    }

    @Override
    public CompanyEmailDeletedEvent deleteEmailCompany(UUID emailUUID) {
        var currentCompanyId = this.securityContextHolder.currentCompany();
        EmailRoot findCurrentCompanyEmail = findCurrentCompanyEmail(emailUUID);
        this.companyEmailDomainService.validateForDeleteEmail(currentCompanyId, findCurrentCompanyEmail);
        this.companyEmailCommandRepositoryAdapter.inActive(findCurrentCompanyEmail);
        if (findCurrentCompanyEmail.getIsPrimary()) {
            changePrimaryStateFirstEmailByCreatedDate(currentCompanyId);
        }
        return CompanyEmailDeletedEvent.of(new CompanyEmailDeletedPayload());
    }

    @Override
    public CompanyEmailUpdatedEvent setPrimaryEmail(UUID emailUUID) {
        var currentCompanyId = this.securityContextHolder.currentCompany();
        List<EmailRoot> emails = companyEmailQueryRepositoryAdapter.fetchCompanyEmailsByCompanyUuid(currentCompanyId);
        this.companyEmailDomainService.validateIfEmailIsPrimary(emails, emailUUID);
        updatePrimaryEmail(emails);
        return CompanyEmailUpdatedEvent.of(new CompanyEmailUpdatedPayload());
    }

    private void changePrimaryStateFirstEmailByCreatedDate(CompanyID companyID) {
        Optional<EmailRoot> optionalEmailRoot =
                this.companyEmailQueryRepositoryAdapter.findFirstEmailByCreatedDate(companyID);
        if (optionalEmailRoot.isPresent()) {
            var findFirstEmailByCreatedDate = optionalEmailRoot.get();
            findFirstEmailByCreatedDate.changePrimary();
            this.companyEmailCommandRepositoryAdapter.update(findFirstEmailByCreatedDate);
        }
    }

    private EmailRoot findCurrentCompanyEmail(UUID emailUUID) {
        return this.companyEmailQueryRepositoryAdapter
                .findEmailById(EmailID.of(emailUUID))
                .orElseThrow(() -> new NoActiveRowException());
    }

    private EmailRoot findCurrentCompanyEmailFromEmailList(List<EmailRoot> emailRootList) {
        return emailRootList.stream()
                .filter(emailRoot -> emailRoot.emailIdEqualityPredicate().test(emailRoot))
                .findAny()
                .orElseThrow(() -> new NoActiveRowException());
    }
    private void updatePrimaryEmail(List<EmailRoot> emails) {
        var changedPrimaryEmail = emails.stream()
                .map(EmailRoot::changeUnPrimary)
                .filter(emailRoot -> emailRoot.emailIdEqualityPredicate().test(emailRoot))
                .map(EmailRoot::changePrimary)
                .findFirst();
        if (changedPrimaryEmail.isPresent()) {
            companyEmailCommandRepositoryAdapter.updateAll(emails);
        }
    }

}
