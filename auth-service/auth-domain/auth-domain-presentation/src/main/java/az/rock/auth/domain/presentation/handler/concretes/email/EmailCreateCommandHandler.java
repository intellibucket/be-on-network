package az.rock.auth.domain.presentation.handler.concretes.email;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.auth.domain.presentation.handler.abstracts.email.AbstractEmailCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractEmailCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.email.EmailCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class EmailCreateCommandHandler implements AbstractEmailCreateCommandHandler {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractEmailCommandRepositoryAdapter emailCommandRepositoryAdapter;
    private final AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter;

    public EmailCreateCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                     AbstractEmailCommandRepositoryAdapter emailCommandRepositoryAdapter,
                                     AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.emailCommandRepositoryAdapter = emailCommandRepositoryAdapter;
        this.emailQueryRepositoryAdapter = emailQueryRepositoryAdapter;
    }

    public EmailCreatedEvent handleEmailCreated(EmailCreateRequest emailCreateRequest) {
        return null;
    }
}
