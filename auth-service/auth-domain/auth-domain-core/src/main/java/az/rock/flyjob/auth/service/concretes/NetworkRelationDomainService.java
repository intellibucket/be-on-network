package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.network.ConnectItselfException;
import az.rock.flyjob.auth.service.abstracts.AbstractNetworkRelationDomainService;

import java.util.UUID;


public class NetworkRelationDomainService implements AbstractNetworkRelationDomainService {
    @Override
    public void validateConnectionItself(UUID currentUserId, UUID targetUserId) {
        if (currentUserId.equals(targetUserId)) throw new ConnectItselfException();
    }
}
