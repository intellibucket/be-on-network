package az.rock.auth.domain.presentation.handler.concretes.user;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.exception.AuthDomainPresentationException;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractQueryRoleDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractEmailQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.exception.UsernameAlreadyExistException;
import az.rock.flyjob.auth.exception.email.EmailAlreadyUsedException;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.valueObject.UserType;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import org.springframework.stereotype.Component;

@Component
public class UserCreateCommandHandler  implements AbstractUserCreateCommandHandler {
    private final AbstractUserDomainService userDomainService;
    private final AbstractUserCommandRepositoryAdapter userRepositoryAdapter;
    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;
    private final AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter;
    private final AbstractUserDomainMapper userDomainMapper;
    private final AbstractQueryRoleDomainPresentationService roleDomainPresentationService;

    public UserCreateCommandHandler(AbstractUserDomainService userDomainService,
                                    AbstractUserCommandRepositoryAdapter userRepositoryAdapter,
                                    AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter,
                                    AbstractEmailQueryRepositoryAdapter emailQueryRepositoryAdapter,
                                    AbstractUserDomainMapper userDomainMapper,
                                    AbstractQueryRoleDomainPresentationService roleDomainPresentationService){
        this.userDomainService = userDomainService;
        this.userRepositoryAdapter = userRepositoryAdapter;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
        this.emailQueryRepositoryAdapter = emailQueryRepositoryAdapter;
        this.userDomainMapper = userDomainMapper;
        this.roleDomainPresentationService = roleDomainPresentationService;
    }

    @Override
    public JobSeekerCreatedEvent handleJobSeekerCreated(CreateUserCommand createUserCommand) {
        this.controlForRegistration(createUserCommand);
        var roleRoot = this.roleDomainPresentationService.findIdByName(UserType.JOB_SEEKER.asRoleName());
        var userRoot = this.userDomainMapper.registrationUserRoot(roleRoot,createUserCommand);
        var userCreatedEvent = this.userDomainService.validateAndInitializeUser(userRoot);
        var savedUserRoot = this.userRepositoryAdapter.create(userRoot);
        if (savedUserRoot.isEmpty()) throw new AuthDomainPresentationException();
        return userCreatedEvent;
    }

    @Override
    public CompanyCreatedEvent handleCompanyCreated(CreateUserCommand createUserCommand) {
        var roleId = this.roleDomainPresentationService.findIdByName(UserType.COMPANY.asRoleName());
        var userRoot = this.userDomainMapper.registrationUserRoot(roleId,createUserCommand);
        var companyCreatedEvent = this.userDomainService.validateAndInitializeCompany(userRoot);
        var savedUserRoot = this.userRepositoryAdapter.create(userRoot);
        if (savedUserRoot.isEmpty()) throw new AuthDomainPresentationException();
        return companyCreatedEvent;
    }

    private void controlForRegistration(CreateUserCommand createUserCommand){
        var existByUsername = this.userQueryRepositoryAdapter.isExistByUsername(createUserCommand.getUsername());
        var existByEmail = this.emailQueryRepositoryAdapter.isExistEmailAsActive(createUserCommand.getEmail());
        if (existByUsername) throw new UsernameAlreadyExistException();
        if (existByEmail) throw new EmailAlreadyUsedException();
    }
}
