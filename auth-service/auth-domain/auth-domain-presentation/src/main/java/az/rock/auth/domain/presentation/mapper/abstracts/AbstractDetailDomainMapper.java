package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.domain.id.RoleID;
import az.rock.lib.domain.id.UserID;

public interface AbstractDetailDomainMapper {
    DetailRoot toNewDetailRoot(UserID userID,RoleID roleID, CreateUserCommand createUserCommand);
}
