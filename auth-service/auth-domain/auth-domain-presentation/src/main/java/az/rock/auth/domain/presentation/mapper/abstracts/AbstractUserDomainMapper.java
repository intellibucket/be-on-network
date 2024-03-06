package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.flyjob.auth.model.root.user.UserRoot;

public interface AbstractUserDomainMapper {
    UserRoot registrationUserRoot(RoleRoot roleID, CreateUserCommand createUserCommand);
}
