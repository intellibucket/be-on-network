package az.rock.auth.domain.presentation.handler.abstracts.user;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import com.intellibucket.lib.payload.event.create.user.CompanyCreatedEvent;
import com.intellibucket.lib.payload.event.create.user.JobSeekerCreatedEvent;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Transactional(propagation = Propagation.REQUIRES_NEW)
public interface AbstractUserCreateCommandHandler {
    JobSeekerCreatedEvent handleJobSeekerCreated(CreateUserCommand createUserCommand);

    CompanyCreatedEvent handleCompanyCreated(CreateUserCommand createUserCommand);
}
