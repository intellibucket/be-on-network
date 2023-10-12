package az.rock.flyjob.auth.service.abstracts;

import java.util.UUID;

public interface AbstractNetworkRelationDomainService {
    void validateConnectionItself(UUID currentUserId,UUID targetUserId);
}
