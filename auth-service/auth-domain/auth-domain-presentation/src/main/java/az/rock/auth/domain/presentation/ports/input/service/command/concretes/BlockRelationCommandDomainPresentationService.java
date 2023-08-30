package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractBlockRelationCommandDomainPresentationService;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BlockRelationCommandDomainPresentationService implements AbstractBlockRelationCommandDomainPresentationService {
    @Override
    public void block(UUID userID) {

    }

    @Override
    public void unblock(UUID userID) {

    }
}
