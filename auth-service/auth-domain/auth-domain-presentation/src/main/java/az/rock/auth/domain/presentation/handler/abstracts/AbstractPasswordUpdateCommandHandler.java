package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.auth.domain.presentation.dto.request.PasswordChangeRequest;
import az.rock.flyjob.auth.event.PasswordUpdatedEvent;

public interface AbstractPasswordUpdateCommandHandler {
    PasswordUpdatedEvent handlePasswordChanged(PasswordChangeRequest passwordChangeRequest);
}
