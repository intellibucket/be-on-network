package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractFollowMessagePublisher;
import com.intellibukcet.lib.payload.event.create.follow.FollowRelationEvent;
import az.rock.lib.domain.id.auth.*;
import com.intellibukcet.lib.payload.event.create.follow.UnfollowRelationEvent;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class FollowCommandDomainPresentationService implements AbstractFollowCommandDomainPresentationService {

    private final AbstractFollowMessagePublisher followMessagePublisher;

    private final AbstractFollowCommandHandler followCommandHandler;

    public FollowCommandDomainPresentationService(AbstractFollowMessagePublisher followMessagePublisher,
                                                  AbstractFollowCommandHandler followCommandHandler) {
        this.followMessagePublisher = followMessagePublisher;
        this.followCommandHandler = followCommandHandler;
    }

    @Override
    public void follow(UUID userID) {
        FollowRelationEvent followRelationEvent = this.followCommandHandler.handleFollow(UserID.of(userID));

    }

    @Override
    public void unfollow(UUID userID) {
        UnfollowRelationEvent unfollowRelationEvent = this.followCommandHandler.handleUnfollow(UserID.of(userID));
    }
}
