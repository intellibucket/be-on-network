package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.handler.abstracts.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.outbox.abstracts.AbstractUserOutboxInputPort;
import az.rock.auth.domain.presentation.ports.output.message.AbstractUserMessagePublisher;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserCommandDomainPresentationService implements AbstractUserCommandDomainPresentationService {
    private final AbstractUserCreateCommandHandler userCreateCommandHandler;
    private final AbstractUserMessagePublisher userMessagePublisher;
    private final AbstractUserOutboxInputPort userOutboxInputPort;
    public UserCommandDomainPresentationService(AbstractUserCreateCommandHandler userCreateCommandHandler,
                                                AbstractUserMessagePublisher userMessagePublisher,
                                                AbstractUserOutboxInputPort userOutboxInputPort) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userMessagePublisher = userMessagePublisher;
        this.userOutboxInputPort = userOutboxInputPort;
    }

    @Override
    @Transactional
    public CreateUserResponse createJobSeeker(CreateUserCommand createUserCommand) {
        JobSeekerCreatedEvent jobSeekerCreatedEvent =
                this.userCreateCommandHandler.handleJobSeekerCreated(createUserCommand);
        this.userOutboxInputPort.save(jobSeekerCreatedEvent);
        this.userMessagePublisher.publish(jobSeekerCreatedEvent);
        return CreateUserResponse.of(jobSeekerCreatedEvent.getRoot());
    }

    @Override
    public CreateUserResponse createCompany(CreateUserCommand createUserCommand) {
        CompanyCreatedEvent userCreatedEvent = this.userCreateCommandHandler.handleCompanyCreated(createUserCommand);
        this.userOutboxInputPort.save(userCreatedEvent);
        this.userMessagePublisher.publish(userCreatedEvent);
        return CreateUserResponse.of(userCreatedEvent.getRoot());
    }


}
