package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.flyjob.auth.event.UserCreatedEvent;

public interface AbstractUserDomainMapper {
    CreateUserResponse toCreateUserResponse(UserCreatedEvent userCreatedEvent);
}
