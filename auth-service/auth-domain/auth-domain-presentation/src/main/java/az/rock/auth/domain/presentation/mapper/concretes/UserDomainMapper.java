package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPasswordDomainMapper;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.flyjob.auth.root.UserRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDomainMapper implements AbstractUserDomainMapper {

    private final AbstractPasswordDomainMapper passwordDomainMapper;

    public UserDomainMapper(AbstractPasswordDomainMapper passwordDomainMapper) {
        this.passwordDomainMapper = passwordDomainMapper;
    }

    public CreateUserResponse toCreateUserResponse(UserRoot userRoot) {
        return new CreateUserResponse(userRoot.getUUID().getId(), userRoot.getUsername(), userRoot.getEmail());
    }

    @Override
    public UserRoot toUserRoot(CreateUserCommand createUserCommand) {
        return UserRoot.Builder
                .builder()
                .id(UserID.of(UUID.randomUUID()))
                .version(1L)
                .username(createUserCommand.getUsername())
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .email(createUserCommand.getEmail())
                .password(this.passwordDomainMapper.toNewPasswordRoot(createUserCommand.getPassword()))
                .build();
    }
}
