package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.flyjob.auth.event.UserCreatedEvent;

public class UserDomainMapper implements AbstractUserDomainMapper {
    public CreateUserResponse toCreateUserResponse(UserCreatedEvent userCreatedEvent) {
        return null;
    }
}
