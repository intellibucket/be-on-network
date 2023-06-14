package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.user.UserRoot;
import az.rock.lib.annotation.OutputPort;
import az.rock.lib.domain.id.UserID;

import java.util.Optional;

@OutputPort
public interface AbstractUserQueryRepositoryAdapter {
    Optional<UserRoot> findById(UserID currentUser);
}
