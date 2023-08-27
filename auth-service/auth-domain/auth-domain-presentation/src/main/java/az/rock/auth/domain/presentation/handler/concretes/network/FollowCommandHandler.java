package az.rock.auth.domain.presentation.handler.concretes.network;

import az.rock.auth.domain.presentation.exception.FollowDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractFollowDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractUserQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.event.email.EmailUpdatedEvent;
import az.rock.flyjob.auth.event.network.FollowRelationEvent;
import az.rock.flyjob.auth.exception.email.EmailNotFoundException;
import az.rock.flyjob.auth.exception.follow.AlreadyFollowedException;
import az.rock.flyjob.auth.exception.follow.FollowSelfTrackingException;
import az.rock.flyjob.auth.exception.follow.UnfollowSelfException;
import az.rock.flyjob.auth.service.abstracts.AbstractFollowDomainService;
import az.rock.lib.domain.id.auth.FollowID;
import az.rock.lib.domain.id.auth.UserID;
import org.springframework.stereotype.Component;

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

    /**
     * alreadyFollowed exist user - in my followers list
     * checkTrackingSelf - user tracking self
     */
    @Override
    public FollowRelationEvent handleFollow(UserID userID) {
        var currentUserIdTypePair = this.securityContextHolder.currentUserTypePair();
        var followingUserType = this.userQueryRepositoryAdapter.findUserTypeById(userID);
        var alreadyFollowed =  this.followQueryRepositoryAdapter.isFollowerPresentInMyFollowers(currentUserIdTypePair.getUserID(),userID);
        if(alreadyFollowed) throw new AlreadyFollowedException();
        var checkTrackingSelf = currentUserIdTypePair.getUserID().equals(userID);
        if(checkTrackingSelf) throw new FollowSelfTrackingException();
        //TODO block metodu yazildiqdan sonra user - in block olub olmadigini yoxla
        var newFollowRelationRoot = this.followDomainMapper.toNewFollowRelationRoot(currentUserIdTypePair,followingUserType);
        var savedRoot = this.followCommandRepositoryAdapter.create(newFollowRelationRoot);
        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
        return FollowRelationEvent.of(savedRoot.get());
    }
    @Override
    public FollowRelationEvent handleUnfollow(UserID followUserID) {
        var currentUserId = this.securityContextHolder.availableUser();
        var checkUnfollowSelf = currentUserId.equals(followUserID);
        if(checkUnfollowSelf) throw new UnfollowSelfException("F0000000034"); // ozunu unfollow ede bilmezsen
//        var alreadyUnfollowed = this.followQueryRepositoryAdapter.isAlreadyUnfollowed(currentUserId,followUserID);
//        if(alreadyUnfollowed) throw new AlreadyUnfollowedException("F0000000035"); // unfollow etdiyini birdaha ede bilmezsen
        var isPresentActiveRelation =  this.followQueryRepositoryAdapter.findActiveRowForUserAndFollowID(currentUserId,followUserID);
        if(isPresentActiveRelation.isPresent()){
            var activeRowRelation = isPresentActiveRelation.get();
            activeRowRelation.inActive();
            this.followCommandRepositoryAdapter.update(activeRowRelation);
            return FollowRelationEvent.of(activeRowRelation);
        }else throw new FollowDomainException("F0000000001");
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
