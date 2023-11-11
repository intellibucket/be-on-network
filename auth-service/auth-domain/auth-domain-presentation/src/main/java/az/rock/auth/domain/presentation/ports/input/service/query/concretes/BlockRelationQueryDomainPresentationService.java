package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractBlockRelationQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractBlockRelationQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.model.root.network.BlockRelationRoot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BlockRelationQueryDomainPresentationService implements AbstractBlockRelationQueryDomainPresentationService {
    private final AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter;
    private final AbstractSecurityContextHolder securityContextHolder;

    public BlockRelationQueryDomainPresentationService(AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter
            , AbstractSecurityContextHolder securityContextHolder) {
        this.blockRelationQueryRepositoryAdapter = blockRelationQueryRepositoryAdapter;
        this.securityContextHolder = securityContextHolder;
    }

    @Override
    public List<UUID> findMyBlockedList() {
        var currentId = this.securityContextHolder.availableUser();
        return this.blockRelationQueryRepositoryAdapter.findMyBlockedList(currentId)
                .stream()
                .map(BlockRelationRoot::getTargetUserId)
                .toList();
    }

    @Override
    public List<UUID> queryWhoBlockedMe() {
        var currentId = this.securityContextHolder.availableUser();
        return this.blockRelationQueryRepositoryAdapter.findWhoBlockedMe(currentId.getAbsoluteID())
                .stream()
                .map(BlockRelationRoot::getUserId)
                .toList();
    }

    @Override
    public List<UUID> queryMyBlockedUserById(UUID targetUserId) {
        var currentId = this.securityContextHolder.availableUser();
        return this.blockRelationQueryRepositoryAdapter.isPresentInMyBlockedList(currentId.getAbsoluteID(),targetUserId)
                .stream()
                .map(BlockRelationRoot::getTargetUserId)
                .toList();
    }
}
