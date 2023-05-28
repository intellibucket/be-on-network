package az.rock.auth.domain.presentation.service.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.auth.domain.presentation.mapper.concretes.UserDomainMapper;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.service.abstracts.AbstractUserDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class UserDomainPresentationService implements AbstractUserDomainPresentationService {
    private final AbstractUserCreateCommandHandler userCreateCommandHandler;
    private final AbstractUserMessagePublisher userMessagePublisher;
    public UserDomainPresentationService(AbstractUserCreateCommandHandler userCreateCommandHandler,
                                         AbstractUserMessagePublisher userMessagePublisher) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userMessagePublisher = userMessagePublisher;
    }

    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        UserCreatedEvent userCreatedEvent = this.userCreateCommandHandler.handle(createUserCommand);
        this.userMessagePublisher.publish(userCreatedEvent);
        return CreateUserResponse.of(userCreatedEvent.getRoot());
    }
}
