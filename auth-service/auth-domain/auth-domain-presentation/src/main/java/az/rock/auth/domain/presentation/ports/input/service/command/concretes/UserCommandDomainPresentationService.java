package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCommandDomainPresentationService implements AbstractUserCommandDomainPresentationService {
    private final AbstractUserCreateCommandHandler userCreateCommandHandler;
    private final AbstractUserMessagePublisher userMessagePublisher;
    public UserCommandDomainPresentationService(AbstractUserCreateCommandHandler userCreateCommandHandler,
                                                AbstractUserMessagePublisher userMessagePublisher) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    @Transactional
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        UserCreatedEvent userCreatedEvent = this.userCreateCommandHandler.handle(createUserCommand);
        this.userMessagePublisher.publish(userCreatedEvent);
        return CreateUserResponse.of(userCreatedEvent.getRoot());
    }
}
