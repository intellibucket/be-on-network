package az.rock.auth.domain.presentation.ports.output.repository.query.user;

import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.*;
import az.rock.lib.valueObject.UserIdTypePair;

import java.util.Optional;

@DomainOutputPort
public interface AbstractUserQueryRepositoryAdapter {

    Optional<UserRoot> findById(UserID currentUser);

    Boolean isExistByUsername(String username);

    UserIdTypePair findUserTypeById(UserID userID);
}
