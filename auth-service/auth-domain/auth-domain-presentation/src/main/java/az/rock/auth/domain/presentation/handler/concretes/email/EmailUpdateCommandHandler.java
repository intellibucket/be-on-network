package az.rock.auth.domain.presentation.handler.concretes.email;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.auth.domain.presentation.handler.abstracts.email.AbstractEmailUpdateCommandHandler;
import az.rock.flyjob.auth.event.email.EmailUpdatedEvent;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.valueObject.SwitchCase;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class EmailUpdateCommandHandler implements AbstractEmailUpdateCommandHandler {

    @Override
    public EmailUpdatedEvent handleEmailChanged(EmailChangeRequest emailChangeRequest) {
        return null;
    }

    @Override
    public EmailUpdatedEvent handleEmailDeleted(EmailID emailID) {
        return null;
    }

    @Override
    public EmailUpdatedEvent handleEmailSetPrimary(EmailID emailID) {
        return null;
    }

    @Override
    public EmailUpdatedEvent handleEmailEnableNotification(SwitchCase switchCase) {
        return null;
    }

    @Override
    public EmailUpdatedEvent handleEmailSubscribedPromotions(SwitchCase switchCase) {
        return null;
    }
}
