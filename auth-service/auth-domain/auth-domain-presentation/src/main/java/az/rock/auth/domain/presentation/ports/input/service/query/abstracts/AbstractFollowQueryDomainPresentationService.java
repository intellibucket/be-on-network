package az.rock.auth.domain.presentation.ports.input.service.query.abstracts;

import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;
@InputPort
@Transactional(readOnly = true)
public interface AbstractFollowQueryDomainPresentationService {
    List<UUID> findMyFollowers();

    List<UUID> findMyFollowings();

    List<UUID> findInMyFollowPendingRequests();

    List<UUID> findMyFollowPendingRequests();
}
