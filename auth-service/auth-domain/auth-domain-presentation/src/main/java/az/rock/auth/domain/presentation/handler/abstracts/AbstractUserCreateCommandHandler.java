package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.event.CompanyCreatedEvent;
import az.rock.flyjob.auth.event.JobSeekerCreatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractUserCreateCommandHandler {
    JobSeekerCreatedEvent handleJobSeekerCreated(CreateUserCommand createUserCommand);

    CompanyCreatedEvent handleCompanyCreated(CreateUserCommand createUserCommand);
}
