package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.domain.id.auth.UserID;

public interface AbstractNetworkRelationCommandDomainInnerService {
    void dumpRelation(UserID currentUserId, UserID targetId);
}
