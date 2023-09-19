package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.exception.block.BlockItselfException;
import az.rock.flyjob.auth.exception.block.UnblockItselfException;
import az.rock.flyjob.auth.exception.email.EmailAlreadyExistException;
import az.rock.flyjob.auth.service.abstracts.AbstractBlockRelationDomainService;

import java.util.UUID;

public class BlockRelationDomainService implements AbstractBlockRelationDomainService {
    @Override
    public void validateBlockingItself(UUID currentUserID, UUID targetUserID) {
        if (currentUserID.equals(targetUserID)) throw new BlockItselfException();
    }

    @Override
    public void validateUnblockingItself(UUID currentUserId, UUID targetUserId) {
        if (currentUserId.equals(targetUserId)) throw new UnblockItselfException();
    }


}
