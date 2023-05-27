package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.flyjob.auth.root.user.UserRoot;

public interface AbstractUserDomainMapper {
    CreateUserResponse toCreateUserResponse(UserRoot userRoot);

    UserRoot toNewUserRoot(CreateUserCommand createUserCommand);
}
