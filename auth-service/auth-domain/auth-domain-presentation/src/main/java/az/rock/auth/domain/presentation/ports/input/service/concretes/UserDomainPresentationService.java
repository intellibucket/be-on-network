package az.rock.auth.domain.presentation.ports.input.service.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.ports.input.service.abstracts.AbstractUserDomainPresentationService;
import az.rock.flyjob.auth.service.abstracts.AbstractUserDomainService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Validated
@Service
public class UserDomainPresentationService implements AbstractUserDomainPresentationService {
    @Override
    public CreateUserResponse createUser(CreateUserCommand createUserCommand) {
        return null;
    }
}
