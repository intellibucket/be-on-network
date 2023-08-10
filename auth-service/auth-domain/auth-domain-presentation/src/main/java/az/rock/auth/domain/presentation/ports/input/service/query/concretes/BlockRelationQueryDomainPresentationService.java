package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractBlockRelationQueryDomainPresentationService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class BlockRelationQueryDomainPresentationService implements AbstractBlockRelationQueryDomainPresentationService {
    @Override
    public List<UUID> queryMyBlockedUser() {
        return null;
    }
}
