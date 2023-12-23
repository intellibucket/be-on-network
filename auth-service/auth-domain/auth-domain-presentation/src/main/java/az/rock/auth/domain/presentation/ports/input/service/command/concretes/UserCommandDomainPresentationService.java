package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractCompanyCreateEventCoordinator;
import az.rock.auth.domain.presentation.coordinator.abstracts.AbstractJobSeekerCreateEventCoordinator;
import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserCreateCommandHandler;
import az.rock.auth.domain.presentation.handler.abstracts.user.AbstractUserUpdateCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractUserCommandDomainPresentationService;
import az.rock.lib.valueObject.Gender;
import az.rock.lib.valueObject.TimeZoneID;
import com.intellibucket.lib.payload.outbox.JobSeekerRegistrationSteps;
import com.intellibucket.lib.payload.trx.SagaProcess;
import org.springframework.stereotype.Service;

@Service
public class UserCommandDomainPresentationService implements AbstractUserCommandDomainPresentationService {
    private final AbstractUserCreateCommandHandler userCreateCommandHandler;
    private final AbstractUserUpdateCommandHandler userUpdateCommandHandler;
    private final AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator;
    private final AbstractCompanyCreateEventCoordinator companyCreateEventCoordinator;


    public UserCommandDomainPresentationService(AbstractUserCreateCommandHandler userCreateCommandHandler,
                                                AbstractUserUpdateCommandHandler userUpdateCommandHandler,
                                                AbstractJobSeekerCreateEventCoordinator jobSeekerCreateEventCoordinator,
                                                AbstractCompanyCreateEventCoordinator companyCreateEventCoordinator) {
        this.userCreateCommandHandler = userCreateCommandHandler;
        this.userUpdateCommandHandler = userUpdateCommandHandler;
        this.jobSeekerCreateEventCoordinator = jobSeekerCreateEventCoordinator;
        this.companyCreateEventCoordinator = companyCreateEventCoordinator;
    }

    @Override
    public void createJobSeeker(CreateUserCommand createUserCommand) {
        var jobSeekerCreatedEvent = this.userCreateCommandHandler.handleJobSeekerCreated(createUserCommand);
        var saga = SagaProcess.onProceed(JobSeekerRegistrationSteps.ON_STARTED, jobSeekerCreatedEvent);
        this.jobSeekerCreateEventCoordinator.coordinate(saga);
    }

    @Override
    public void createCompany(CreateUserCommand createUserCommand) {
        var userCreatedEvent = this.userCreateCommandHandler.handleCompanyCreated(createUserCommand);
    }



    @Override
    public void changeFirstName(String firstName) {
        var event = this.userUpdateCommandHandler.handleFirstnameUpdated(firstName);
    }

    @Override
    public void changeLastName(String lastName) {
        var event = this.userUpdateCommandHandler.handleLastnameUpdated(lastName);
    }

    @Override
    public void changeUsername(String username) {
        var event = this.userUpdateCommandHandler.handleUsernameUpdated(username);
    }

    @Override
    public void changeGender(Gender gender) {
        var event = this.userUpdateCommandHandler.handleGenderUpdated(gender);
    }

    @Override
    public void changeTimezone(TimeZoneID timezone) {
        var event = this.userUpdateCommandHandler.handleTimezoneUpdated(timezone);
    }

    @Override
    public void changeTitle(String title) {
        var event = this.userUpdateCommandHandler.handleTitleUpdated(title);
    }

    @Override
    public void changeBiography(String biography) {
        var event = this.userUpdateCommandHandler.handleBiographyUpdated(biography);
    }


}
