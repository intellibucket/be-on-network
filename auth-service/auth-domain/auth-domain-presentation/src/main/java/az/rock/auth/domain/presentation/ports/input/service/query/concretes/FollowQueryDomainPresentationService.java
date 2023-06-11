package az.rock.auth.domain.presentation.ports.input.service.query.concretes;

import az.rock.auth.domain.presentation.context.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.ports.input.service.query.abstracts.AbstractFollowQueryDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowQueryRepositoryAdapter;
import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.UUID;

@Component
public class FollowQueryDomainPresentationService  implements AbstractFollowQueryDomainPresentationService {
    private final AbstractFollowQueryRepositoryAdapter followQueryRepositoryAdapter;
    private final AbstractSecurityContextHolder securityContextHolder;

    public FollowQueryDomainPresentationService(AbstractFollowQueryRepositoryAdapter followQueryRepositoryAdapter,
                                                AbstractSecurityContextHolder securityContextHolder) {
        this.followQueryRepositoryAdapter = followQueryRepositoryAdapter;
        this.securityContextHolder = securityContextHolder;
    }


    @Override
    public List<UUID> findMyFollowers() {
        var currentId = this.securityContextHolder.currentUser();
        return this.followQueryRepositoryAdapter.findMyFollowers(currentId)
                .stream()
                .map(FollowRelationRoot::getFollowingUserId)
                .toList();
    }

    @Override
    public List<UUID> findMyFollowings() {
        var currentId = this.securityContextHolder.currentUser();
        return this.followQueryRepositoryAdapter.findMyFollowings(currentId)
                .stream()
                .map(FollowRelationRoot::getFollowedUserId)
                .toList();
    }

    @Override
    public List<UUID> findInMyFollowPendingRequests() {
        var currentId = this.securityContextHolder.currentUser();
        return this.followQueryRepositoryAdapter.findInMyFollowPendingRequests(currentId)
                .stream()
                .map(FollowRelationRoot::getFollowingUserId)
                .toList();
    }

    @Override
    public List<UUID> findMyFollowPendingRequests() {
        var currentId = this.securityContextHolder.currentUser();
        return this.followQueryRepositoryAdapter.findMyFollowPendingRequests(currentId)
                .stream()
                .map(FollowRelationRoot::getFollowedUserId)
                .toList();
    }
}
