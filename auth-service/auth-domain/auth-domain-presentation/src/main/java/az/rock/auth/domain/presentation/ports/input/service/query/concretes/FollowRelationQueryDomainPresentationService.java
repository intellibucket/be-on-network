package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractFollowRelationQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowRelationQueryRepositoryAdapter;
import az.rock.flyjob.auth.model.root.network.FollowRelationRoot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class FollowRelationQueryDomainPresentationService implements AbstractFollowRelationQueryDomainPresentationService {
    private final AbstractFollowRelationQueryRepositoryAdapter followQueryRepositoryAdapter;
    private final AbstractSecurityContextHolder securityContextHolder;

    public FollowRelationQueryDomainPresentationService(AbstractFollowRelationQueryRepositoryAdapter followQueryRepositoryAdapter,
                                                        AbstractSecurityContextHolder securityContextHolder) {
        this.followQueryRepositoryAdapter = followQueryRepositoryAdapter;
        this.securityContextHolder = securityContextHolder;
    }


    @Override
    public List<UUID> findMyFollowers() {
        var currentId = this.securityContextHolder.availableUser();
        return this.followQueryRepositoryAdapter.findMyFollowers(currentId)
                .stream()
                .map(FollowRelationRoot::getFollowingUserId)
                .toList();
    }

    @Override
    public List<UUID> findMyFollowings() {
        var currentId = this.securityContextHolder.availableUser();
        return this.followQueryRepositoryAdapter.findMyFollowings(currentId)
                .stream()
                .map(FollowRelationRoot::getFollowedUserId)
                .toList();
    }
}
