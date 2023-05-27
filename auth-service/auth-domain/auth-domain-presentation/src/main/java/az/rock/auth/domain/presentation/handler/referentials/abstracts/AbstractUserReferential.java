package az.rock.auth.domain.presentation.handler.referentials.abstracts;

import az.rock.auth.domain.presentation.dto.request.CreateUserCommand;
import az.rock.flyjob.auth.root.user.UserRoot;

public interface AbstractUserReferential {
    UserRoot createReferentialUser(CreateUserCommand createUserCommand);
}
