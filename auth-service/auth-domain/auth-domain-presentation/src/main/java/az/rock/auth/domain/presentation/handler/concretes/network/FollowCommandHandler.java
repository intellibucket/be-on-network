package az.rock.auth.domain.presentation.handler.concretes.network;

import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowCommandHandler;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowQueryRepositoryAdapter;
import az.rock.flyjob.auth.event.network.FollowRelationEvent;
import az.rock.flyjob.auth.service.abstracts.AbstractFollowDomainService;
import az.rock.lib.domain.id.auth.FollowID;
import org.springframework.stereotype.Component;

@Component
public class FollowCommandHandler implements AbstractFollowCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractFollowCommandRepositoryAdapter followCommandRepositoryAdapter;

    private final AbstractFollowQueryRepositoryAdapter followQueryRepositoryAdapter;

    private final AbstractFollowDomainService followDomainService;

    public FollowCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                AbstractFollowCommandRepositoryAdapter followCommandRepositoryAdapter,
                                AbstractFollowDomainService followDomainService,
                                AbstractFollowQueryRepositoryAdapter followQueryRepositoryAdapter
                                ) {
        this.securityContextHolder = securityContextHolder;
        this.followCommandRepositoryAdapter = followCommandRepositoryAdapter;
        this.followDomainService = followDomainService;
        this.followQueryRepositoryAdapter = followQueryRepositoryAdapter;
    }

    @Override
    public FollowRelationEvent handleFollow(FollowID followID) {
        return null;
    }

    @Override
    public FollowRelationEvent handleUnfollow(FollowID followID) {
        return null;
    }

    @Override
    public FollowRelationEvent handleAcceptFollowRequest(FollowID followID) {
        return null;
    }

    @Override
    public FollowRelationEvent handleRejectFollowRequest(FollowID followID) {
        return null;
    }

    @Override
    public FollowRelationEvent handleCancelFollowRequest(FollowID followID) {
        return null;
    }


}
