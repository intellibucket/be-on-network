package az.rock.auth.domain.presentation.handler.concretes;

import az.rock.auth.domain.presentation.exception.FollowDomainException;
import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowRelationCommandHandler;
import az.rock.auth.domain.presentation.mapper.abstracts.AbstractFollowDomainMapper;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractBlockRelationQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowRelationQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.user.AbstractUserQueryRepositoryAdapter;
import az.rock.auth.domain.presentation.security.AbstractSecurityContextHolder;
import az.rock.flyjob.auth.exception.block.BlockRelationWhenFollowException;
import az.rock.flyjob.auth.exception.follow.AlreadyFollowedException;
import az.rock.flyjob.auth.exception.follow.UnfollowSelfException;
import az.rock.flyjob.auth.model.root.network.FollowRelationRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractFollowRelationDomainService;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.event.create.follow.FollowRelationEvent;
import com.intellibucket.lib.payload.event.create.follow.UnfollowRelationEvent;
import com.intellibucket.lib.payload.event.create.user.payload.follow.FollowRelationPayload;
import org.springframework.stereotype.Component;

@Component
public class FollowRelationCommandHandler implements AbstractFollowRelationCommandHandler {

    private final AbstractSecurityContextHolder securityContextHolder;

    private final AbstractFollowRelationCommandRepositoryAdapter followRelationCommandRepositoryAdapter;

    private final AbstractFollowRelationQueryRepositoryAdapter followQueryRepositoryAdapter;

    private final AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter;
    private final AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter;

    private final AbstractFollowRelationDomainService followDomainService;

    private final AbstractFollowDomainMapper followDomainMapper;



    public FollowRelationCommandHandler(AbstractSecurityContextHolder securityContextHolder,
                                        AbstractFollowRelationCommandRepositoryAdapter followCommandRepositoryAdapter,
                                        AbstractFollowRelationDomainService followDomainService,
                                        AbstractFollowRelationQueryRepositoryAdapter followQueryRepositoryAdapter,
                                        AbstractFollowDomainMapper followDomainMapper,
                                        AbstractUserQueryRepositoryAdapter userQueryRepositoryAdapter,
                                        AbstractBlockRelationQueryRepositoryAdapter blockRelationQueryRepositoryAdapter) {
        this.securityContextHolder = securityContextHolder;
        this.followRelationCommandRepositoryAdapter = followCommandRepositoryAdapter;
        this.followDomainService = followDomainService;
        this.followQueryRepositoryAdapter = followQueryRepositoryAdapter;
        this.followDomainMapper = followDomainMapper;
        this.userQueryRepositoryAdapter = userQueryRepositoryAdapter;
        this.blockRelationQueryRepositoryAdapter = blockRelationQueryRepositoryAdapter;
    }

    /**
     * alreadyFollowed exist user - in my followers list
     * checkTrackingSelf - user tracking self
     */
    @Override
    public FollowRelationEvent handleFollow(UserID targetUserId) {
        var currentUserIdTypePair = this.securityContextHolder.currentUserTypePair();
        var followingUserType = this.userQueryRepositoryAdapter.findUserTypeById(targetUserId);
        var alreadyFollowed =  this.followQueryRepositoryAdapter.isFollowerPresentInMyFollowers(currentUserIdTypePair.getUserID(),targetUserId);
        if(alreadyFollowed) throw new AlreadyFollowedException();
        this.followDomainService.validateTrackingSelf(currentUserIdTypePair.getUserID(),targetUserId);
        var blockRelation =  this.blockRelationQueryRepositoryAdapter.blockRelationByUsers(currentUserIdTypePair.getUserID().getAbsoluteID(),targetUserId.getAbsoluteID());
        if(blockRelation) throw new BlockRelationWhenFollowException();
        var newFollowRelationRoot = this.followDomainMapper.toNewFollowRelationRoot(currentUserIdTypePair,followingUserType);
        var savedRoot = this.followRelationCommandRepositoryAdapter.create(newFollowRelationRoot);
        if (savedRoot.isEmpty()) throw new FollowDomainException("F0000000001");
        return FollowRelationEvent.of(this.fromRoot(savedRoot.get()));
    }


    @Override
    public UnfollowRelationEvent handleUnfollow(UserID targetUserId) {
        UserID currentUserId = getCurrentUserId(targetUserId);
        return dumpFollowRelation(currentUserId,targetUserId);
    }

    @Override
    public UnfollowRelationEvent handleRemove(UserID targetUserId) {
        UserID currentUserId = getCurrentUserId(targetUserId);
        return dumpFollowRelation(targetUserId,currentUserId);
    }

    private UserID getCurrentUserId(UserID targetUserId) {
        var currentUserId = this.securityContextHolder.availableUser();
        var checkUnfollowSelf = currentUserId.equals(targetUserId);
        if(checkUnfollowSelf) throw new UnfollowSelfException("F0000000034");
        return currentUserId;
    }

    private UnfollowRelationEvent dumpFollowRelation(UserID sourceUserId, UserID targetUserId) {
        var isPresentActiveRelation =  this.followQueryRepositoryAdapter.findActiveRowForUserAndFollowID(sourceUserId, targetUserId);
        if(isPresentActiveRelation.isPresent()){
            var activeRowRelation = isPresentActiveRelation.get();
            this.followRelationCommandRepositoryAdapter.inActive(activeRowRelation);
            return UnfollowRelationEvent.of(this.fromRoot(activeRowRelation));
        }else throw new FollowDomainException("F0000000037");
    }


    private FollowRelationPayload fromRoot(FollowRelationRoot followRelationRoot){
        return FollowRelationPayload.Builder
                .builder()
                .blockReasonStatus(followRelationRoot.getBlockReasonStatus())
                .followingUserId(followRelationRoot.getFollowingUserId())
                .followerUserId(followRelationRoot.getFollowedUserId())
                .followingUserType(followRelationRoot.getFollowingUserType())
                .followerUserType(followRelationRoot.getFollowerUserType())
                .followStatus(followRelationRoot.getFollowStatus())
                .build();
    }
}
