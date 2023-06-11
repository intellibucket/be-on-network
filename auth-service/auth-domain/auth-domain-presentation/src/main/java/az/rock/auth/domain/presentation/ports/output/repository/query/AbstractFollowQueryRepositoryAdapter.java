package az.rock.auth.domain.presentation.ports.output.repository.query;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.UserID;

import java.util.List;

public interface AbstractFollowQueryRepositoryAdapter {
    List<FollowRelationRoot> findMyFollowers(UserID userID);

    List<FollowRelationRoot> findMyFollowings(UserID userID);

    List<FollowRelationRoot> findMyFollowPendingRequests(UserID userID);

}
