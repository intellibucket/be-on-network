package az.rock.auth.domain.presentation.handler.abstracts.network;

import az.rock.flyjob.auth.event.email.EmailUpdatedEvent;
import az.rock.flyjob.auth.event.network.FollowRelationEvent;
import az.rock.lib.domain.id.EmailID;
import az.rock.lib.domain.id.FollowID;
import az.rock.lib.domain.id.UserID;

public interface AbstractFollowCommandHandler {

    FollowRelationEvent handleFollow(UserID userID);

    FollowRelationEvent handleUnfollow(UserID userID);

    FollowRelationEvent handleAcceptFollowRequest(FollowID followID);

    FollowRelationEvent handleRejectFollowRequest(FollowID followID);

    FollowRelationEvent handleCancelFollowRequest(FollowID followID);

}
