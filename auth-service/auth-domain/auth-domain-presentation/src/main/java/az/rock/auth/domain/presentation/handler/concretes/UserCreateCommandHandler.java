package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractQueryRoleDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.auth.domain.presentation.exception.AuthDomainException;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.valueObject.UserType;
import org.springframework.stereotype.Component;

@Component
public class UserCreateCommandHandler  implements AbstractUserCreateCommandHandler {
    private final AbstractUserDomainService userDomainService;
    private final AbstractUserCommandRepositoryAdapter userRepositoryAdapter;

    private final AbstractUserDomainMapper userDomainMapper;

    private final AbstractQueryRoleDomainPresentationService roleDomainPresentationService;


    public UserCreateCommandHandler(AbstractUserDomainService userDomainService,
                                    AbstractUserCommandRepositoryAdapter userRepositoryAdapter,
                                    AbstractUserDomainMapper userDomainMapper,
                                    AbstractQueryRoleDomainPresentationService roleDomainPresentationService){
        this.userDomainService = userDomainService;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userDomainMapper = userDomainMapper;
        this.roleDomainPresentationService = roleDomainPresentationService;
    }

    @Override
    public UserCreatedEvent handleUserCreated(CreateUserCommand createUserCommand) {
        var roleRoot = this.roleDomainPresentationService.findIdByName(UserType.JOB_SEEKER.asRoleName());
        var userRoot = this.userDomainMapper.registrationUserRoot(roleRoot,createUserCommand);
        var userCreatedEvent = this.userDomainService.validateAndInitializeUser(userRoot);
        var savedUserRoot = this.userRepositoryAdapter.create(userCreatedEvent.getRoot());
        if (savedUserRoot.isEmpty()) throw new AuthDomainException();
        return userCreatedEvent;
    }

    @Override
    public CompanyCreatedEvent handleCompanyCreated(CreateUserCommand createUserCommand) {
        var roleId = this.roleDomainPresentationService.findIdByName(UserType.COMPANY.asRoleName());
        var userRoot = this.userDomainMapper.registrationUserRoot(roleId,createUserCommand);
        var companyCreatedEvent = this.userDomainService.validateAndInitializeCompany(userRoot);
        var savedUserRoot = this.userRepositoryAdapter.create(companyCreatedEvent.getRoot());
        if (savedUserRoot.isEmpty()) throw new AuthDomainException();
        return companyCreatedEvent;
    }
}
