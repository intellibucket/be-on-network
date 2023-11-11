package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.flyjob.auth.model.root.detail.DetailRoot;
import az.rock.lib.domain.id.auth.*;

public interface AbstractDetailDomainMapper {
    DetailRoot toNewDetailRoot(UserID userID, RoleRoot roleRoot, CreateUserCommand createUserCommand);
}
