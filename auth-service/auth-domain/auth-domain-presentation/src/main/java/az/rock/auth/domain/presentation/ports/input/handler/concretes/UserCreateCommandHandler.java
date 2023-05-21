package az.rock.auth.domain.presentation.ports.input.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.auth.domain.presentation.ports.input.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.AbstractUserRepositoryAdapter;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import org.springframework.stereotype.Component;

@Component
public class UserCreateCommandHandler  implements AbstractUserCreateCommandHandler {
    private final AbstractUserDomainService userDomainService;
    private final AbstractUserDomainMapper userDomainMapper;
    private final AbstractUserRepositoryAdapter userRepositoryAdapter;

    public UserCreateCommandHandler(AbstractUserDomainService userDomainService,
                                    AbstractUserDomainMapper userDomainMapper,
                                    AbstractUserRepositoryAdapter userRepositoryAdapter) {
        this.userDomainService = userDomainService;
        this.userDomainMapper = userDomainMapper;
        this.userRepositoryAdapter = userRepositoryAdapter;
    }

    @Override
    public UserCreatedEvent handle(CreateUserCommand createUserCommand) {

        return null;
    }
}
