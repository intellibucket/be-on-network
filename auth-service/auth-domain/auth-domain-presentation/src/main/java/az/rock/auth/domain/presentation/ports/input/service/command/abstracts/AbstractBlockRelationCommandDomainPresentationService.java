package az.rock.auth.domain.presentation.ports.input.service.command.abstracts;

import az.rock.lib.annotation.InputPort;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@InputPort
@Transactional
public interface AbstractBlockRelationCommandDomainPresentationService {

    void block(UUID targetUserID);

    void unblock(UUID userID);
}
