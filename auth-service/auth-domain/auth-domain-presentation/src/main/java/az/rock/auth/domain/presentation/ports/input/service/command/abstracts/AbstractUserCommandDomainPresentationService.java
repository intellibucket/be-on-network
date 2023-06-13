package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

@InputPort
@Transactional
public interface AbstractUserCommandDomainPresentationService {
    CreateUserResponse createJobSeeker(CreateUserCommand createUserCommand);

    CreateUserResponse createCompany(CreateUserCommand createUserCommand);
}
