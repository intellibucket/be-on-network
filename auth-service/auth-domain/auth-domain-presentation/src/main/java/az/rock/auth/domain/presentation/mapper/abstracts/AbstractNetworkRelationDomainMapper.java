package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.network.NetworkRelationRoot;
import az.rock.lib.domain.id.auth.UserID;

public interface AbstractNetworkRelationDomainMapper {

    NetworkRelationRoot toNewNetworkRelationRoot(UserID userID, UserID targetUserID);

}
