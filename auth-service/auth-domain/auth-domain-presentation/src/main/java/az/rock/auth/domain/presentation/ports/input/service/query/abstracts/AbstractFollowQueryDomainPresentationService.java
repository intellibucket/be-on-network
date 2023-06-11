package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import java.util.List;
import java.util.UUID;

public interface AbstractFollowQueryDomainPresentationService {
    List<UUID> findMyFollowers();

    List<UUID> findMyFollowings();

    List<UUID> findInMyFollowPendingRequests();
}
