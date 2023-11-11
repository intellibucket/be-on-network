package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.follow.AlreadyFollowedException;
import az.rock.flyjob.auth.exception.follow.FollowSelfTrackingException;
import az.rock.flyjob.auth.model.root.network.FollowRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractFollowRelationDomainService;
import az.rock.lib.domain.id.auth.*;

import java.util.List;

public class FollowDomainService implements AbstractFollowRelationDomainService {

    @Override
    public void validateFollowRequestAlready(List<FollowRelationRoot> followers, FollowID followID) {
        var activeFollowerInMyFollowers = followers.stream()
                .filter(item -> FollowID.of(item.getFollowingUserId())
                        .equals(followID)).findFirst();
        if (activeFollowerInMyFollowers.isPresent()) throw new AlreadyFollowedException();
    }

    @Override
    public void validateTrackingSelf(UserID currentUserId, UserID targetUserId) {
        var checkTrackingSelf = currentUserId.equals(targetUserId);
        if(checkTrackingSelf) throw new FollowSelfTrackingException();
    }


}
