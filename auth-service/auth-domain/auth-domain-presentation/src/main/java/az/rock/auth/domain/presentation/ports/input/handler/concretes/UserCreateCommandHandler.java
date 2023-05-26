package az.rock.auth.domain.presentation.ports.input.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.auth.domain.presentation.ports.input.handler.abstracts.AbstractDetailCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.AbstractUserRepositoryAdapter;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.auth.domain.presentation.exception.AuthDomainException;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import org.springframework.stereotype.Component;

@Component
public class UserCreateCommandHandler  implements AbstractUserCreateCommandHandler {
    private final AbstractUserDomainService userDomainService;
    private final AbstractUserDomainMapper userDomainMapper;
    private final AbstractUserRepositoryAdapter userRepositoryAdapter;

    private final AbstractDetailCreateCommandHandler detailCreateCommandHandler;



    public UserCreateCommandHandler(AbstractUserDomainService userDomainService,
                                    AbstractUserDomainMapper userDomainMapper,
                                    AbstractUserRepositoryAdapter userRepositoryAdapter, AbstractDetailCreateCommandHandler detailCreateCommandHandler) {
        this.userDomainService = userDomainService;
        this.userDomainMapper = userDomainMapper;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.detailCreateCommandHandler = detailCreateCommandHandler;
    }

    @Override
    public UserCreatedEvent handle(CreateUserCommand createUserCommand) {
        var userRoot = this.userDomainMapper.toNewUserRoot(createUserCommand);
        var detailRootEvent = this.detailCreateCommandHandler.handle(userRoot);
        userRoot.setUserRootAndDetailRootPair(detailRootEvent.getRoot());
        var userCreatedEvent = this.userDomainService.validateAndInitializeUser(userRoot);
        var savedUserRoot = this.userRepositoryAdapter.create(userCreatedEvent.getRoot());
        if (savedUserRoot.isEmpty()) throw new AuthDomainException();
        return userCreatedEvent;
    }
}
