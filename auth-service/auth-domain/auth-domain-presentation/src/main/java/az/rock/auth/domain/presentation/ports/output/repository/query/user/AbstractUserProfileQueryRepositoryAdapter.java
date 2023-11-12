package az.rock.auth.domain.presentation.ports.output.repository.query.user;

import az.rock.flyjob.auth.model.query.AnyProfileQueryRecord;
import az.rock.flyjob.auth.model.query.MyProfileQueryRecord;
import az.rock.lib.annotation.DomainOutputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@DomainOutputPort
@Transactional(readOnly = true)
public interface AbstractUserProfileQueryRepositoryAdapter {
    Optional<MyProfileQueryRecord> findMyProfile(UUID userID);

    Optional<AnyProfileQueryRecord> findAnyProfile(UUID authenticatedUserId, UUID targetUserId);
}
