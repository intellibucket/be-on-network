package az.rock.auth.domain.presentation.handler.referentials.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.handler.referentials.abstracts.AbstractUserReferential;
import az.rock.auth.domain.presentation.mapper.concretes.DetailDomainMapper;
import az.rock.auth.domain.presentation.mapper.concretes.UserDomainMapper;
import az.rock.flyjob.auth.root.user.UserRoot;
import org.springframework.stereotype.Component;

@Component
public class UserReferential implements AbstractUserReferential {
    private final UserDomainMapper userDomainMapper;
    private final DetailDomainMapper detailDomainMapper;

    public UserReferential(UserDomainMapper userDomainMapper, DetailDomainMapper detailDomainMapper) {
        this.userDomainMapper = userDomainMapper;
        this.detailDomainMapper = detailDomainMapper;
    }

    @Override
    public UserRoot createReferentialUser(CreateUserCommand createUserCommand) {
        var userRoot = this.userDomainMapper.registrationUserRoot(createUserCommand);
        return userRoot;
    }
}
