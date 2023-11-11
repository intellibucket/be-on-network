package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.network.NetworkRelationRoot;

import java.util.List;
import java.util.UUID;

public interface AbstractNetworkRelationDomainService {
    void validateConnectionItself(UUID currentUserId,UUID targetUserId);

    void validateActiveNetworkRelation(List<NetworkRelationRoot> networkRelationRootList);

//    void validateActiveNetworkRelationOnPendingStatus(Boolean networkRelation);
}
