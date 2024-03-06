package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowRelationCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowRelationCommandDomainInnerService;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowRelationCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractFollowRelationMessagePublisher;
import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractFollowRelationCommandRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractFollowRelationQueryRepositoryAdapter;
import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.event.create.follow.FollowRelationEvent;
import com.intellibucket.lib.payload.event.create.follow.UnfollowRelationEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FollowRelationCommandDomainPresentationService implements AbstractFollowRelationCommandDomainInnerService, AbstractFollowRelationCommandDomainPresentationService {

    private final AbstractFollowRelationMessagePublisher followMessagePublisher;

    private final AbstractFollowRelationCommandHandler followCommandHandler;

    private final AbstractFollowRelationCommandRepositoryAdapter followRelationCommandRepositoryAdapter;

    private final AbstractFollowRelationQueryRepositoryAdapter followRelationQueryRepositoryAdapter;

    public FollowRelationCommandDomainPresentationService(AbstractFollowRelationMessagePublisher followMessagePublisher,
                                                          AbstractFollowRelationCommandHandler followCommandHandler,
                                                          AbstractFollowRelationCommandRepositoryAdapter followRelationCommandRepositoryAdapter, AbstractFollowRelationQueryRepositoryAdapter followRelationQueryRepositoryAdapter) {
        this.followMessagePublisher = followMessagePublisher;
        this.followCommandHandler = followCommandHandler;
        this.followRelationCommandRepositoryAdapter = followRelationCommandRepositoryAdapter;
        this.followRelationQueryRepositoryAdapter = followRelationQueryRepositoryAdapter;
    }

    @Override
    public void follow(UUID targetUserId) {
        FollowRelationEvent followRelationEvent = this.followCommandHandler.handleFollow(UserID.of(targetUserId));

    }

    @Override
    public void unfollow(UUID targetUserId) {
        UnfollowRelationEvent unfollowRelationEvent = this.followCommandHandler.handleUnfollow(UserID.of(targetUserId));
    }

    @Override
    public void remove(UUID targetUserId) {
        UnfollowRelationEvent removeRelationEvent = this.followCommandHandler.handleRemove(UserID.of(targetUserId));
    }

    @Override
    public void dumpRelation(UserID currentUserId,UserID targetId) {
        var followRelation = this.followRelationQueryRepositoryAdapter
                                        .findRelationByUsersID( currentUserId.getAbsoluteID(),targetId.getAbsoluteID());
        followRelation.forEach(item -> {
            if (item.getFollowingUserId().equals(targetId.getAbsoluteID())) {
                item.blockReasonStatusByOwner();
            }else if (item.getFollowingUserId().equals(currentUserId.getAbsoluteID())) {
                item.blockReasonStatusByTarget();
            }
            item.inActive();
            followRelationCommandRepositoryAdapter.update(item);
        });

    }
}
