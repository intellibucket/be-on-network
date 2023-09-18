package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.auth.*;
import az.rock.lib.valueObject.UserIdTypePair;

import java.util.List;
import java.util.UUID;

public interface AbstractFollowRelationDomainService {
    void validateFollowRequestAlready(List<FollowRelationRoot> followers, FollowID followID);

    void validateTrackingSelf(UserID currentUserId, UserID targetUserId);

}
