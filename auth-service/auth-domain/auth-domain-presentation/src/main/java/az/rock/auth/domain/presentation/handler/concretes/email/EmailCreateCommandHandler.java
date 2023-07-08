package az.rock.auth.domain.presentation.handler.concretes.email;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.auth.domain.presentation.exception.EmailDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.email.AbstractEmailCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractEmailDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractEmailCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.email.EmailCreatedEvent;
import az.rock.flyjob.auth.exception.email.EmailAlreadyUsedException;
import az.rock.flyjob.auth.service.abstracts.AbstractEmailDomainService;
import org.springframework.stereotype.Component;

@Component
public class EmailCreateCommandHandler implements AbstractEmailCreateCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter;
    private final AbstractEmailCommandRepositoryAdapter emailCommandRepositoryAdapter;
    private final AbstractEmailDomainService emailDomainService;

    private final AbstractEmailDomainMapper emailDomainMapper;

    public EmailCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                     AbstractEmailCommandRepositoryAdapter emailCommandRepositoryAdapter,
                                     AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter,
                                     AbstractEmailDomainService emailDomainService,
                                     AbstractEmailDomainMapper emailDomainMapper) {
        this.securityContextHolder = securityContextHolder;
        this.emailCommandRepositoryAdapter = emailCommandRepositoryAdapter;
        this.emailQueryRepositoryAdapter = emailQueryRepositoryAdapter;
        this.emailDomainService = emailDomainService;
        this.emailDomainMapper = emailDomainMapper;
    }

    public EmailCreatedEvent handleEmailCreated(EmailCreateRequest emailCreateRequest) {
        var currentUserId = this.securityContextHolder.availableUser();
        var activeEmails = this.emailQueryRepositoryAdapter.findAllMyEmails(currentUserId);
        var newEmailRoot = this.emailDomainMapper.toNewEmailRoot(currentUserId,emailCreateRequest);
        var alreadyUsed = this.emailQueryRepositoryAdapter.isExistEmailAsActive(newEmailRoot.getEmail());
        if (alreadyUsed) throw new EmailAlreadyUsedException();
        this.emailDomainService.validateNewEmail(activeEmails,newEmailRoot);
        var savedRoot = this.emailCommandRepositoryAdapter.create(newEmailRoot);
        if (savedRoot.isEmpty()) throw new EmailDomainException("F0000000001");
        return EmailCreatedEvent.of(savedRoot.get());
    }
}
