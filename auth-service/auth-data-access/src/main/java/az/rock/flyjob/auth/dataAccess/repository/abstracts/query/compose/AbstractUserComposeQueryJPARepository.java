package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.compose;

import az.rock.flyjob.auth.dataAccess.model.compose.UserSimpleCompose;

import java.util.Optional;
import java.util.UUID;

public interface AbstractUserComposeQueryJPARepository {
    Optional<UserSimpleCompose> findUserSimpleComposeByUserId(UUID userId);
}
