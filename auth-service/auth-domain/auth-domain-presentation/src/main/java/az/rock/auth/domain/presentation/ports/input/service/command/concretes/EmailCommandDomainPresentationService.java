package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.auth.domain.presentation.handler.abstracts.email.AbstractEmailCreateCommandHandler;
import az.rock.auth.domain.presentation.handler.abstracts.email.AbstractEmailUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractEmailCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.message.AbstractEmailMessagePublisher;
import az.rock.flyjob.auth.event.email.EmailCreatedEvent;
import az.rock.flyjob.auth.root.user.EmailRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.valueObject.SagaRoot;
import az.rock.lib.valueObject.SwitchCase;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class EmailCommandDomainPresentationService implements AbstractEmailCommandDomainPresentationService {
    private final AbstractEmailMessagePublisher emailMessagePublisher;
    private final AbstractEmailUpdateCommandHandler emailUpdateCommandHandler;
    private final AbstractEmailCreateCommandHandler emailCreateCommandHandler;

    public EmailCommandDomainPresentationService(AbstractEmailMessagePublisher emailMessagePublisher,
                                                 AbstractEmailUpdateCommandHandler emailUpdateCommandHandler,
                                                 AbstractEmailCreateCommandHandler emailCreateCommandHandler) {
        this.emailMessagePublisher = emailMessagePublisher;
        this.emailUpdateCommandHandler = emailUpdateCommandHandler;
        this.emailCreateCommandHandler = emailCreateCommandHandler;
    }


    @Override
    public void add(EmailCreateRequest emailCreateRequest) {
        EmailCreatedEvent emailCreatedEvent = this.emailCreateCommandHandler.handleEmailCreated(emailCreateRequest);
        SagaRoot<AbstractDomainEvent<EmailRoot>> sagaRoot = SagaRoot.of(emailCreatedEvent);
        this.emailMessagePublisher.publish(sagaRoot);
    }

    @Override
    public void change(EmailChangeRequest emailChangeRequest) {

    }

    @Override
    public void delete(UUID emailUUID) {

    }

    @Override
    public void setPrimary(UUID emailUUID) {

    }

    @Override
    public void switchEnableNotification(SwitchCase switchCase) {

    }

    @Override
    public void switchSubscribedPromotions(SwitchCase switchCase) {

    }
}
