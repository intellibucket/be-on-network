package az.rock.auth.domain.presentation.handler.abstracts.network;

import az.rock.lib.domain.id.auth.UserID;
import com.intellibucket.lib.payload.event.create.follow.FollowRelationEvent;
import com.intellibucket.lib.payload.event.create.follow.UnfollowRelationEvent;

public interface AbstractFollowRelationCommandHandler {

    FollowRelationEvent handleFollow(UserID userID);

    UnfollowRelationEvent handleUnfollow(UserID userID);

    UnfollowRelationEvent handleRemove(UserID userID);
}
