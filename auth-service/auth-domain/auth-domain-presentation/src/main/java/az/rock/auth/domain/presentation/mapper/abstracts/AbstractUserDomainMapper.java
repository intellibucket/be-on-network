package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.*;

public interface AbstractUserDomainMapper {
    UserRoot registrationUserRoot(RoleRoot roleID, CreateUserCommand createUserCommand);
}
