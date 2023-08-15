package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.outbox.abstracts.AbstractUserOutboxInputPort;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractUserMessagePublisher;
import az.rock.flyjob.auth.event.user.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.user.JobSeekerCreatedEvent;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import org.springframework.stereotype.Service;

@Service
public class UserCommandDomainPresentationService implements AbstractUserCommandDomainPresentationService {
    private final AbstractUserCreateCommandHandler userCreateCommandHandler;

    private final AbstractUserUpdateCommandHandler userUpdateCommandHandler;
    private final AbstractUserMessagePublisher userMessagePublisher;
    private final AbstractUserOutboxInputPort userOutboxInputPort;


    public UserCommandDomainPresentationService(AbstractUserCreateCommandHandler userCreateCommandHandler,
                                                AbstractUserUpdateCommandHandler userUpdateCommandHandler,
                                                AbstractUserMessagePublisher userMessagePublisher,
                                                AbstractUserOutboxInputPort userOutboxInputPort) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userUpdateCommandHandler = userUpdateCommandHandler;
        this.userMessagePublisher = userMessagePublisher;
        this.userOutboxInputPort = userOutboxInputPort;
    }

    @Override
    public CreateUserResponse createJobSeeker(CreateUserCommand createUserCommand) {
        JobSeekerCreatedEvent jobSeekerCreatedEvent =
                this.userCreateCommandHandler.handleJobSeekerCreated(createUserCommand);
        var sagaRoot= this.userOutboxInputPort.save(jobSeekerCreatedEvent);
        this.userMessagePublisher.publish(sagaRoot);
        return CreateUserResponse.of(jobSeekerCreatedEvent.getData());
    }

    @Override
    public CreateUserResponse createCompany(CreateUserCommand createUserCommand) {
        CompanyCreatedEvent userCreatedEvent = this.userCreateCommandHandler.handleCompanyCreated(createUserCommand);
        var sagaRoot= this.userOutboxInputPort.save(userCreatedEvent);
        this.userMessagePublisher.publish(sagaRoot);
        return CreateUserResponse.of(userCreatedEvent.getData());
    }



    @Override
    public void changeFirstName(String firstName) {
        var event = this.userUpdateCommandHandler.handleFirstnameUpdated(firstName);
        var sagaRoot = this.userOutboxInputPort.save(event);
        this.userMessagePublisher.publish(sagaRoot);
    }

    @Override
    public void changeLastName(String lastName) {
        var event = this.userUpdateCommandHandler.handleLastnameUpdated(lastName);
        var sagaRoot = this.userOutboxInputPort.save(event);
        this.userMessagePublisher.publish(sagaRoot);
    }

    @Override
    public void changeUsername(String username) {
        var event = this.userUpdateCommandHandler.handleUsernameUpdated(username);
        var sagaRoot = this.userOutboxInputPort.save(event);
        this.userMessagePublisher.publish(sagaRoot);
    }

    @Override
    public void changeGender(Gender gender) {
        var event = this.userUpdateCommandHandler.handleGenderUpdated(gender);
        var sagaRoot = this.userOutboxInputPort.save(event);
        this.userMessagePublisher.publish(sagaRoot);
    }

    @Override
    public void changeTimezone(TimeZoneID timezone) {
        var event = this.userUpdateCommandHandler.handleTimezoneUpdated(timezone);
        var sagaRoot = this.userOutboxInputPort.save(event);
        this.userMessagePublisher.publish(sagaRoot);
    }


}
