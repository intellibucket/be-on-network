package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.UserID;

import java.util.List;
import java.util.Optional;

@DomainOutputPort
public interface AbstractNetworkQueryRepositoryAdapter {

    List<NetworkRelationRoot> findNetworkRelationByBothOfUserIDs(UserID firstUserID, UserID secondUserID);
    List<NetworkRelationRoot> findMyNetworks(UserID currentUserID);

    List<NetworkRelationRoot> findMyNetworksByUIDs(UserID currentUserId, UserID targetUserId);

    List<NetworkRelationRoot> findInMyNetworkPendingRequests(UserID currentUserID);

    List<NetworkRelationRoot> findMyPendingRequests(UserID currentUserID);
    Optional<NetworkRelationRoot> findActiveNetworkRelationOnPendingStatus(UserID currentUserId, UserID targetUserId);
    Optional<NetworkRelationRoot> findMutualActiveNetworkRelationOnPendingStatus(UserID currentUserId, UserID targetUserId);



}
