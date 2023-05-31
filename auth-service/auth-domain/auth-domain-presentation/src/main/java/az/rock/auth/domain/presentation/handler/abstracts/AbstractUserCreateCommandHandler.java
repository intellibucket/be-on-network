package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public interface AbstractUserCreateCommandHandler {

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    UserCreatedEvent handle(CreateUserCommand createUserCommand);
}
