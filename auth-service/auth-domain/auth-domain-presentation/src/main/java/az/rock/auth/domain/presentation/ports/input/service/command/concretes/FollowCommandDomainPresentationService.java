package az.rock.auth.domain.presentation.ports.input.service.command.concretes;

import az.rock.auth.domain.presentation.handler.abstracts.network.AbstractFollowCommandHandler;
import az.rock.auth.domain.presentation.ports.input.service.command.abstracts.AbstractFollowCommandDomainPresentationService;
import az.rock.auth.domain.presentation.ports.output.publisher.AbstractFollowMessagePublisher;
import az.rock.flyjob.auth.event.network.FollowRelationEvent;
import az.rock.lib.domain.id.auth.FollowID;
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
    public void follow(UUID uuid) {
        FollowRelationEvent followRelationEvent = this.followCommandHandler.handleFollow(FollowID.of(uuid));
    }

    @Override
    public void unfollow(UUID userID) {

    }

    @Override
    public void acceptFollowRequest(UUID followRelationID) {

    }

    @Override
    public void rejectFollowRequest(UUID followRelationID) {

    }

    @Override
    public void cancelFollowRequest(UUID followRelationID) {

    }
}
