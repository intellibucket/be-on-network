package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.auth.*;

import java.util.List;

public interface AbstractFollowRelationDomainService {
    void validateFollowRequestAlready(List<FollowRelationRoot> followers, FollowID followID);

    void validateTrackingSelf(UserID currentUserId, UserID targetUserId);

}
