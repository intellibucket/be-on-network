package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.UserID;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@DomainOutputPort
public interface AbstractNetworkQueryRepositoryAdapter {

    Optional<NetworkRelationRoot> findNetworkRelationByBothOfUserIDs(UserID firstUserID, UserID secondUserID);
    List<NetworkRelationRoot> findMyNetworks(UserID currentUserID);

    List<NetworkRelationRoot> findInMyNetworkPendingRequests(UserID currentUserID);

    List<NetworkRelationRoot> findMyPendingRequests(UserID currentUserID);
}
