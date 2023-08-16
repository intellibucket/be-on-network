package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.follow.FollowHasAlreadyException;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractFollowDomainService;
import az.rock.lib.domain.id.auth.*;

import java.util.List;

public class FollowDomainService implements AbstractFollowDomainService {
    @Override
    public void validateFollowRequestAlready(List<FollowRelationRoot> followers, FollowID followID) {
        var activeFollowerInMyFollowers = followers.stream()
                .filter(item -> item.getFollowingUserId()
                        .equals(followID)).findFirst();
        if (activeFollowerInMyFollowers.isPresent()) throw new FollowHasAlreadyException();
    }
}
