package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.flyjob.auth.event.UserCreatedEvent;
import az.rock.flyjob.auth.root.UserRoot;

public class UserDomainMapper implements AbstractUserDomainMapper {
    public CreateUserResponse toCreateUserResponse(UserRoot userRoot) {
        return null;
    }
}
