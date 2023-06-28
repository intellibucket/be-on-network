package az.rock.auth.domain.presentation.handler.abstracts.email;

import az.rock.auth.domain.presentation.dto.request.EmailChangeRequest;
import az.rock.flyjob.auth.event.email.EmailUpdatedEvent;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.valueObject.SwitchCase;

import java.util.UUID;

public interface AbstractEmailUpdateCommandHandler {
    EmailUpdatedEvent handleEmailChanged(EmailChangeRequest emailChangeRequest);

    EmailUpdatedEvent handleEmailDeleted(EmailID emailID);

    EmailUpdatedEvent handleEmailSetPrimary(EmailID emailID);

    EmailUpdatedEvent handleEmailNotification(SwitchCase switchCase);

    EmailUpdatedEvent handleEmailSubscribedPromotions(SwitchCase switchCase);
}
