package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.valueObject.UserIdTypePair;

public interface AbstractFollowDomainMapper {

    FollowRelationRoot toNewFollowRelationRoot(UserIdTypePair userID, UserIdTypePair followUserID);
}
