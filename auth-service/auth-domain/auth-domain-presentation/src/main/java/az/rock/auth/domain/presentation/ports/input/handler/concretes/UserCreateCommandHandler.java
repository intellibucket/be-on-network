package az.rock.auth.domain.presentation.ports.input.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.ports.input.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserCreateCommandHandler  implements AbstractUserCreateCommandHandler {
    @Override
    public UserCreatedEvent handle(CreateUserCommand createUserCommand) {
        return null;
    }
}
