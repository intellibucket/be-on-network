package az.rock.auth.domain.presentation.ports.output.repository.query.user;

import az.rock.flyjob.auth.model.root.user.UserRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.UserIdTypePair;

import java.util.Optional;

@DomainOutputPort
public interface AbstractUserQueryRepositoryAdapter {

    Optional<UserRoot> findById(UserID currentUser);

    //Fetch data on eager
    default Optional<UserRoot> fetchById(UserID currentUser) {
        return this.findById(currentUser);
    }

    Boolean isExistByUsername(String username);

    UserIdTypePair findUserTypeById(UserID userID);
}
