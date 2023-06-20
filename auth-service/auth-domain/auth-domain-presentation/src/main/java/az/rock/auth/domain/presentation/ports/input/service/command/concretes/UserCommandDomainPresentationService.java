package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.exception.AuthDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.outbox.abstracts.AbstractUserOutboxInputPort;
import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.stereotype.Service;

@Service
public class UserCommandDomainPresentationService implements AbstractUserCommandDomainPresentationService {
    private final AbstractSecurityContextHolder securityContextHolder;
    private final AbstractUserCreateCommandHandler userCreateCommandHandler;
    private final AbstractUserMessagePublisher userMessagePublisher;
    private final AbstractUserOutboxInputPort userOutboxInputPort;

    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;

    private final AbstractUserDomainService userDomainService;
    public UserCommandDomainPresentationService(AbstractSecurityContextHolder securityContextHolder,
                                                AbstractUserCreateCommandHandler userCreateCommandHandler,
                                                AbstractUserMessagePublisher userMessagePublisher,
                                                AbstractUserOutboxInputPort userOutboxInputPort,
                                                AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter,
                                                AbstractUserDomainService userDomainService) {
        this.securityContextHolder = securityContextHolder;
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userMessagePublisher = userMessagePublisher;
        this.userOutboxInputPort = userOutboxInputPort;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
        this.userDomainService = userDomainService;
    }

    @Override
    public CreateUserResponse createJobSeeker(CreateUserCommand createUserCommand) {
        JobSeekerCreatedEvent jobSeekerCreatedEvent =
                this.userCreateCommandHandler.handleJobSeekerCreated(createUserCommand);
        var sagaRoot= this.userOutboxInputPort.save(jobSeekerCreatedEvent);
        this.userMessagePublisher.publish(sagaRoot);
        return CreateUserResponse.of(jobSeekerCreatedEvent.getRoot());
    }

    @Override
    public CreateUserResponse createCompany(CreateUserCommand createUserCommand) {
        CompanyCreatedEvent userCreatedEvent = this.userCreateCommandHandler.handleCompanyCreated(createUserCommand);
        var sagaRoot= this.userOutboxInputPort.save(userCreatedEvent);
        this.userMessagePublisher.publish(sagaRoot);
        return CreateUserResponse.of(userCreatedEvent.getRoot());
    }

    private UserRoot findCurrentUser(){
        var currentUserID = this.securityContextHolder.currentUser();
        var currentUserRoot = this.userQueryRepositoryAdapter.findById(currentUserID);
        if (currentUserRoot.isEmpty()) throw new AuthDomainException("F0000000018");
        return currentUserRoot.get();
    }

    @Override
    public void changeFirstName(String firstName) {
        var currentUserRoot = this.findCurrentUser();
        this.userDomainService.changeFirstName(currentUserRoot, firstName);
    }

    @Override
    public void changeLastName(String lastName) {

    }

    @Override
    public void changeUsername(String username) {

    }

    @Override
    public void changeGender(Gender gender) {

    }

    @Override
    public void changeTimezone(TimeZoneID timezone) {

    }


}
