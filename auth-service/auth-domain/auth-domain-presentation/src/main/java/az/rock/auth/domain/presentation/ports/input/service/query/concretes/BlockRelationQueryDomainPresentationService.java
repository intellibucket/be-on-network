package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractBlockRelationQueryDomainPresentationService;

import java.util.List;
import java.util.UUID;

public class BlockRelationQueryDomainPresentationService implements AbstractBlockRelationQueryDomainPresentationService {
    @Override
    public List<UUID> queryMyBlockedUser() {
        return null;
    }
}
