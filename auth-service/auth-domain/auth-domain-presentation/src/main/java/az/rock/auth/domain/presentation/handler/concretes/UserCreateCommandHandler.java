package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractDetailCreateCommandHandler;
import az.rock.auth.domain.presentation.handler.referentials.abstracts.AbstractUserReferential;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.AbstractUserRepositoryAdapter;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.auth.domain.presentation.exception.AuthDomainException;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import org.springframework.stereotype.Component;

@Component
public class UserCreateCommandHandler  implements AbstractUserCreateCommandHandler {
    private final AbstractUserDomainService userDomainService;
    private final AbstractUserRepositoryAdapter userRepositoryAdapter;
    private final AbstractUserReferential userReferential;



    public UserCreateCommandHandler(AbstractUserDomainService userDomainService,
                                    AbstractUserRepositoryAdapter userRepositoryAdapter,
                                    AbstractUserReferential userReferential) {
        this.userDomainService = userDomainService;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userReferential = userReferential;
    }

    @Override
    public UserCreatedEvent handle(CreateUserCommand createUserCommand) {
        var userRoot = this.userReferential.createReferentialUser(createUserCommand);
        var userCreatedEvent = this.userDomainService.validateAndInitializeUser(userRoot);
        var savedUserRoot = this.userRepositoryAdapter.create(userCreatedEvent.getRoot());
        if (savedUserRoot.isEmpty()) throw new AuthDomainException();
        return userCreatedEvent;
    }
}
