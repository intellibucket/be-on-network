package az.rock.auth.domain.presentation.handler.concretes.network;

import az.rock.auth.domain.presentation.exception.FollowDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractFollowDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.event.email.EmailCreatedEvent;
import az.rock.flyjob.auth.event.network.FollowRelationEvent;
import az.rock.flyjob.auth.exception.follow.FollowAlreadyException;
import az.rock.flyjob.auth.service.abstracts.AbstractFollowDomainService;
import az.rock.lib.domain.id.auth.FollowID;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class FollowCommandHandler implements AbstractFollowCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractFollowCommandRepositoryAdapter followCommandRepositoryAdapter;

    private final AbstractFollowQueryRepositoryAdapter followQueryRepositoryAdapter;

    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;

    private final AbstractFollowDomainService followDomainService;

    private final AbstractFollowDomainMapper followDomainMapper;



    public FollowCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                AbstractFollowCommandRepositoryAdapter followCommandRepositoryAdapter,
                                AbstractFollowDomainService followDomainService,
                                AbstractFollowQueryRepositoryAdapter followQueryRepositoryAdapter,
                                AbstractFollowDomainMapper followDomainMapper,
                                AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter
                                ) {
        this.securityContextHolder = securityContextHolder;
        this.followCommandRepositoryAdapter = followCommandRepositoryAdapter;
        this.followDomainService = followDomainService;
        this.followQueryRepositoryAdapter = followQueryRepositoryAdapter;
        this.followDomainMapper = followDomainMapper;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
    }

    @Override
    public FollowRelationEvent handleFollow(UserID userID) {
        var currentUserId = this.securityContextHolder.availableUser();
        var currentUserType = this.userQueryRepositoryAdapter.findUserTypeById(currentUserId);
        var followingUserType = this.userQueryRepositoryAdapter.findUserTypeById(userID);
        var alreadyFollowed =  this.followQueryRepositoryAdapter.isFollowerPresentInMyFollowers(currentUserId,userID);
        if(alreadyFollowed) throw new FollowAlreadyException();
        //block metodu yazildiqdan sonra user - in block olub olmadigini yoxla
        var newFollowRelationRoot = this.followDomainMapper.toNewFollowRelationRoot(currentUserType,followingUserType);
        var savedRoot = this.followCommandRepositoryAdapter.create(newFollowRelationRoot);
        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
        return FollowRelationEvent.of(savedRoot.get());


    }

    @Override
    public FollowRelationEvent handleUnfollow(UserID userID) {
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
