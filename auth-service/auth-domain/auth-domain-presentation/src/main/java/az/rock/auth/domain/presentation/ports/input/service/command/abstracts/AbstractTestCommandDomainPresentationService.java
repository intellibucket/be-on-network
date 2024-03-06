package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import java.util.UUID;

public interface AbstractTestCommandDomainPresentationService {
    void testRollbackForUser(UUID userId);
}
