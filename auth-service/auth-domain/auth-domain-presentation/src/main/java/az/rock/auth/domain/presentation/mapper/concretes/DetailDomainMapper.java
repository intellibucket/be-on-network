package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractDetailDomainMapper;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

@Component
public class DetailDomainMapper implements AbstractDetailDomainMapper {
    @Override
    public DetailRoot toNewDetailRoot(UserID userID, CreateUserCommand createUserCommand) {
        return null;
    }
}
