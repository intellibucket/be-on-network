package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.dto.response.CreateUserResponse;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDetailDomainMapper;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractEmailDomainMapper;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractPasswordDomainMapper;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractUserDomainMapper;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UserDomainMapper implements AbstractUserDomainMapper {

    private final AbstractPasswordDomainMapper passwordDomainMapper;

    private final AbstractDetailDomainMapper detailDomainMapper;

    private final AbstractEmailDomainMapper emailDomainMapper;

    public UserDomainMapper(AbstractPasswordDomainMapper passwordDomainMapper,
                            AbstractDetailDomainMapper detailDomainMapper,
                            AbstractEmailDomainMapper emailDomainMapper) {
        this.passwordDomainMapper = passwordDomainMapper;
        this.detailDomainMapper = detailDomainMapper;
        this.emailDomainMapper = emailDomainMapper;
    }

    public CreateUserResponse toCreateUserResponse(UserRoot userRoot) {
        return new CreateUserResponse(userRoot.getUUID().getId(), userRoot.getUsername(), userRoot.getAbsoluteEmail());
    }

    @Override
    public UserRoot toNewUserRoot(CreateUserCommand createUserCommand) {
        var emailRoot = this.emailDomainMapper.toNewEmailRoot(createUserCommand.getEmail());
        var passwordRoot = this.passwordDomainMapper.toNewPasswordRoot(createUserCommand.getPassword());
        return UserRoot.Builder
                .builder()
                .id(UserID.of(UUID.randomUUID()))
                .version(1L)
                .username(createUserCommand.getUsername())
                .firstName(createUserCommand.getFirstName())
                .lastName(createUserCommand.getLastName())
                .email(emailRoot)
                .password(passwordRoot)
                .build();
    }
}
