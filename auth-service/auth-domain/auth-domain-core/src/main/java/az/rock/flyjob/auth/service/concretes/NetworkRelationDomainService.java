package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.network.AlreadyHasActiveNetworkRelationException;
import az.rock.flyjob.auth.exception.network.ConnectItselfException;
import az.rock.flyjob.auth.exception.network.NetworkStatusNotValidException;
import az.rock.flyjob.auth.root.network.NetworkRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractNetworkRelationDomainService;
import az.rock.lib.valueObject.NetworkStatus;

import java.util.List;
import java.util.UUID;


public class NetworkRelationDomainService implements AbstractNetworkRelationDomainService {
    @Override
    public void validateConnectionItself(UUID currentUserId, UUID targetUserId) {
        if (currentUserId.equals(targetUserId)) throw new ConnectItselfException();
    }

    @Override
    public void validateActiveNetworkRelation(List<NetworkRelationRoot> networkRelationRootList) {
        if (!networkRelationRootList.isEmpty()) {
            throw new AlreadyHasActiveNetworkRelationException();
        }
    }

//    @Override
//    public void validateActiveNetworkRelationOnPendingStatus(Boolean networkRelation) {
//        if(!networkRelation.equals(NetworkStatus.PENDING)){
//           throw new NetworkStatusNotValidException();
//        }
//    }
}
