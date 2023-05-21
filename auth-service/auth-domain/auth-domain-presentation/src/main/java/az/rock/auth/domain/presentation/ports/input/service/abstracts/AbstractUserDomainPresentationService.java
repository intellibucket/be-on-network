package az.rock.auth.domain.presentation.ports.input.service.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;

public interface AbstractUserDomainPresentationService {
    CreateUserResponse createUser(CreateUserCommand createUserCommand);
}
