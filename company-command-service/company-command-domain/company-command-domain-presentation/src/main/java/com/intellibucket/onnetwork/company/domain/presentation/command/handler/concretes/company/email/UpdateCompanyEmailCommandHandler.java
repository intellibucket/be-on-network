package com.intellibucket.onnetwork.company.domain.presentation.command.handler.concretes.company.email;

import az.rock.lib.domain.id.auth.EmailID;
import com.intellibucket.lib.event.create.email.CompanyEmailCreatedEvent;
import com.intellibucket.lib.event.create.email.CompanyEmailUpdatedEvent;
import com.intellibucket.lib.payload.email.CompanyEmailCreatedPayload;
import com.intellibucket.onnetwork.company.domain.core.command.exception.EmailAlreadyUsedException;
import com.intellibucket.onnetwork.company.domain.core.command.service.abstracts.AbstractsCompanyEmailDomainService;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailChangedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.dto.request.company.email.CompanyEmailCreatedCommand;
import com.intellibucket.onnetwork.company.domain.presentation.command.exception.EmailDomainException;
import com.intellibucket.onnetwork.company.domain.presentation.command.handler.abstracts.company.email.AbstractUpdateCompanyEmailHandler;
import com.intellibucket.onnetwork.company.domain.presentation.command.mapper.abstracts.AbstractCompanyEmailDomainMapper;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.command.AbstractCompanyEmailCommandRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.ports.output.repository.query.AbstractCompanyEmailQueryRepositoryAdapter;
import com.intellibucket.onnetwork.company.domain.presentation.command.security.AbstractSecurityContextHolder;
import org.springframework.stereotype.Component;

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

//    @Override
//    public CompanyEmailCreatedEvent create(CompanyEmailCreatedCommand companyEmailChangedCommand) {
//        var currentCompanyId = this.securityContextHolder.currentCompany();
//        var activeEmails = this.companyEmailQueryRepositoryAdapter.getCompanyEmailsByCompanyUuid(currentCompanyId);
//        companyEmailDomainService.validateMaxEmailCount(activeEmails);
//        var newEmailRoot = this.companyEmailDomainMapper.toNewCompanyEmailRoot(companyEmailChangedCommand,currentCompanyId);
//        var alreadyUsed = this.companyEmailQueryRepositoryAdapter.isExistEmailAsActive(newEmailRoot.getEmail());
//        if (alreadyUsed) throw new EmailAlreadyUsedException();
//        var savedRoot = this.companyEmailCommandRepositoryAdapter.create(newEmailRoot);
//        if (savedRoot.isEmpty()) throw new EmailDomainException("F0000000001");
//        return CompanyEmailCreatedEvent.of(new CompanyEmailCreatedPayload());
//
//
//    }

    @Override
    public CompanyEmailUpdatedEvent changeEmail(CompanyEmailChangedCommand companyEmailChangedCommand) {
//        var currentCompanyId = this.securityContextHolder.currentCompany();

        var oldEmailOptional = this.companyEmailQueryRepositoryAdapter.findEmailById(EmailID.of(companyEmailChangedCommand.getEmailUUID()));
        if(oldEmailOptional.isPresent()){
            var oldEmail = oldEmailOptional.get();
            var newEmail = this.companyEmailDomainMapper.mapToEmailRoot(oldEmail,companyEmailChangedCommand);
            this.companyEmailDomainService.validateForChangeEmail(oldEmail,newEmail);
        }
//        var optionalOldEmail = emails.stream().filter(item->item.getRootID().getAbsoluteID().equals(companyEmailChangedCommand.getEmailUUID())).findFirst();
//        if(optionalOldEmail.isPresent()){
//            var oldEmail  = optionalOldEmail.get();
//            var newEmail = this.companyEmailDomainMapper.mapToEmailRoot(oldEmail,emailChangeRequest);
//            this.emailDomainService.validateForChangeEmail(oldEmail,newEmail);
//            this.emailCommandRepositoryAdapter.update(newEmail);
//            return EmailUpdatedEvent.of(newEmail);
//        }else throw new EmailNotFoundException();
        return null;
    }
}
