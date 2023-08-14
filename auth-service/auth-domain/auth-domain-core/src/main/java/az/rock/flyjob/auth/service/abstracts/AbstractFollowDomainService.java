package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.domain.id.FollowID;

import java.util.List;

public interface AbstractFollowDomainService {
    void validateFollowRequestAlready(List<FollowRelationRoot> followers, FollowID followID);
}
