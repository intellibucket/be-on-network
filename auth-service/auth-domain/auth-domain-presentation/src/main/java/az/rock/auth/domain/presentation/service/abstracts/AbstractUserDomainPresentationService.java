package az.rock.auth.domain.presentation.service.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.lib.annotation.InputPort;

@InputPort
public interface AbstractUserDomainPresentationService {
    CreateUserResponse createUser(CreateUserCommand createUserCommand);
}
