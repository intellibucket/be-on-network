package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.network.FollowRelationRoot;
import az.rock.lib.valueObject.UserIdTypePair;

public interface AbstractFollowDomainMapper {

    FollowRelationRoot toNewFollowRelationRoot(UserIdTypePair userID, UserIdTypePair followUserID);

    FollowRelationRoot mapToFollowRelationRoot(UserIdTypePair userID, UserIdTypePair followID);
}
