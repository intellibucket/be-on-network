package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractBlockRelationCommandDomainPresentationService;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class BlockRelationCommandDomainPresentationService implements AbstractBlockRelationCommandDomainPresentationService {
    @Override
    public void block(UUID targetUserUuid) {

    }

    @Override
    public void unblock(UUID targetUserUuid) {

    }
}
