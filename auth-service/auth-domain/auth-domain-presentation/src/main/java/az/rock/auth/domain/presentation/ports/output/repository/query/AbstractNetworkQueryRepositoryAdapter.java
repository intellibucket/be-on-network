package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.UUID;

public interface AbstractNetworkQueryRepositoryAdapter {
    List<UUID> findMyNetworks(UserID currentUserID);

    List<UUID> findInMyNetworkPendingRequests(UserID currentUserID);

    List<UUID> findMyPendingRequests(UserID currentUserID);
}
