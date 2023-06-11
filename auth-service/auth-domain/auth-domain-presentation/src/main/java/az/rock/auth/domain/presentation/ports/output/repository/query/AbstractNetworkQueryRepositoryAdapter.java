package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.UUID;

public interface AbstractNetworkQueryRepositoryAdapter {
    List<NetworkRelationRoot> findMyNetworks(UserID currentUserID);

    List<NetworkRelationRoot> findInMyNetworkPendingRequests(UserID currentUserID);

    List<NetworkRelationRoot> findMyPendingRequests(UserID currentUserID);
}
