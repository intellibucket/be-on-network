package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import java.util.UUID;

public interface AbstractBlockRelationCommandDomainPresentationService {
    void block(UUID targetUserUuid);
    void unblock(UUID targetUserUuid);
}
