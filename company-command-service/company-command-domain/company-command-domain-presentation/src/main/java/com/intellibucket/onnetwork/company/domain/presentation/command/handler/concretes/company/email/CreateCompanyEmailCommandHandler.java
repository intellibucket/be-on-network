package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company.email;

import com.intellibucket.lib.event.create.email.CompanyEmailCreatedEvent;
import com.intellibucket.lib.payload.email.CompanyEmailCreatedPayload;
import com.intellibucket.onnetwork.company.domain.core.command.exception.email.EmailAlreadyUsedException;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyEmailDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.exception.EmailDomainException;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractCreateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyEmailDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyEmailQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Component;

@Component
public class CreateCompanyEmailCommandHandler implements AbstractCreateCompanyEmailHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractCompanyEmailQueryRepositoryAdapter companyEmailQueryRepositoryAdapter;
    private final AbstractCompanyEmailCommandRepositoryAdapter companyEmailCommandRepositoryAdapter;
    private final AbstractsCompanyEmailDomainService abstractsCompanyEmailDomainService;
    private final AbstractCompanyEmailDomainMapper companyEmailDomainMapper;

    public CreateCompanyEmailCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                            AbstractCompanyEmailQueryRepositoryAdapter companyEmailQueryRepositoryAdapter,
                                            AbstractCompanyEmailCommandRepositoryAdapter companyEmailCommandRepositoryAdapter,
                                            AbstractsCompanyEmailDomainService abstractsCompanyEmailDomainService,
                                            AbstractCompanyEmailDomainMapper companyEmailDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.companyEmailQueryRepositoryAdapter = companyEmailQueryRepositoryAdapter;
        this.companyEmailCommandRepositoryAdapter = companyEmailCommandRepositoryAdapter;
        this.abstractsCompanyEmailDomainService = abstractsCompanyEmailDomainService;
        this.companyEmailDomainMapper = companyEmailDomainMapper;
    }

    @Override
    public CompanyEmailCreatedEvent createEmailCompany(CompanyEmailCreatedCommand companyEmailChangedCommand) {
        var currentCompanyId = this.securityContextHolder.currentCompany();
        var activeEmails = this.companyEmailQueryRepositoryAdapter.fetchCompanyEmailsByCompanyUuid(currentCompanyId);
        abstractsCompanyEmailDomainService.validateMaxEmailCount(activeEmails);
        var newEmailRoot = this.companyEmailDomainMapper.toNewCompanyEmailRoot(companyEmailChangedCommand,currentCompanyId);
        var alreadyUsed = this.companyEmailQueryRepositoryAdapter.isExistEmailAsActive(newEmailRoot.getEmail());
        if (alreadyUsed) throw new EmailAlreadyUsedException();
        var savedRoot = this.companyEmailCommandRepositoryAdapter.create(newEmailRoot);
        if (savedRoot.isEmpty()) throw new EmailDomainException("F0000000001");
        return CompanyEmailCreatedEvent.of(new CompanyEmailCreatedPayload());
    }
}
