package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.annotation.DomainOutputPort;
import az.rock.lib.domain.id.auth.UserID;

import java.util.List;
import java.util.Optional;

@DomainOutputPort
public interface AbstractFollowQueryRepositoryAdapter {
    List<FollowRelationRoot> findMyFollowers(UserID userID);

    List<FollowRelationRoot> findMyFollowings(UserID userID);

    List<FollowRelationRoot> findMyFollowPendingRequests(UserID userID);

    List<FollowRelationRoot> findInMyFollowPendingRequests(UserID userID);

    Boolean isFollowerPresentInMyFollowers(UserID userID, UserID followUserID);

    Optional<FollowRelationRoot> findActiveRowForUserAndFollowID(UserID userID, UserID followingUserID);
}
