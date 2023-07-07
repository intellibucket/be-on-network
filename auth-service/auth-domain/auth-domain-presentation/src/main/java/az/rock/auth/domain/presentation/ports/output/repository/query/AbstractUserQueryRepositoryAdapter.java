package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.UserID;

import java.util.Optional;

@DomainOutputPort
public interface AbstractUserQueryRepositoryAdapter {
    Optional<UserRoot> findById(UserID currentUser);

    Boolean isExistByUsername(String username);
}
