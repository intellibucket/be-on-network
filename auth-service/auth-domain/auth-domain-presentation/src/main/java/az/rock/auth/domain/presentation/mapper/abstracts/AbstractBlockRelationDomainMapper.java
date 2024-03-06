package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import az.rock.lib.valueObject.UserIdTypePair;

public interface AbstractBlockRelationDomainMapper {

    BlockRelationRoot toNewBlockRelationRoot(UserIdTypePair currentUserID, UserIdTypePair targetUserID);

   // BlockRelationRoot mapToFollowRelationRoot(UserIdTypePair userID, UserIdTypePair followID);

}
