package az.rock.auth.domain.presentation.handler.abstracts.network;

import az.rock.flyjob.auth.event.email.EmailUpdatedEvent;
import az.rock.flyjob.auth.event.network.FollowRelationEvent;
import az.rock.lib.domain.id.auth.FollowID;

public interface AbstractFollowCommandHandler {

    FollowRelationEvent handleFollow(FollowID followID);

    FollowRelationEvent handleUnfollow(FollowID followID);

    FollowRelationEvent handleAcceptFollowRequest(FollowID followID);

    FollowRelationEvent handleRejectFollowRequest(FollowID followID);

    FollowRelationEvent handleCancelFollowRequest(FollowID followID);

}
