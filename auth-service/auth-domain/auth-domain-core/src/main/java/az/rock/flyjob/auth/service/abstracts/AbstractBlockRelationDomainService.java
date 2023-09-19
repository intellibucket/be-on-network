package az.rock.flyjob.auth.service.abstracts;

import java.util.UUID;

public interface AbstractBlockRelationDomainService {
    void validateBlockingItself(UUID currentUserID,UUID targetUserID);

    void validateUnblockingItself(UUID currentUserId, UUID targetUserId);


}
