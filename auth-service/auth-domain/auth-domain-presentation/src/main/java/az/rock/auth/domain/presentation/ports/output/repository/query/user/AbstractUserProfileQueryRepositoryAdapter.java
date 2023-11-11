package az.rock.auth.domain.presentation.ports.output.repository.query.user;

import az.rock.flyjob.auth.model.query.UserProfileQueryRecord;
import az.rock.lib.annotation.DomainOutputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractUserProfileQueryRepositoryAdapter {
    Optional<UserProfileQueryRecord> findMyProfile(UUID userID);
}
