package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.domain.id.UserID;

public interface AbstractDetailDomainMapper {
    DetailRoot toNewDetailRoot(UserID userID, CreateUserCommand createUserCommand);
}
