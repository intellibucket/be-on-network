package az.rock.auth.domain.presentation.handler.abstracts.email;

import az.rock.auth.domain.presentation.dto.request.EmailCreateRequest;
import az.rock.flyjob.auth.event.email.EmailCreatedEvent;

public interface AbstractEmailCreateCommandHandler {
    EmailCreatedEvent handleEmailCreated(EmailCreateRequest emailCreateRequest);
}
