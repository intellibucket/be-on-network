package az.rock.auth.domain.presentation.handler.abstracts.network;

import com.intellibukcet.lib.payload.event.create.follow.FollowRelationEvent;
import az.rock.lib.domain.id.auth.*;
import com.intellibukcet.lib.payload.event.create.follow.UnfollowRelationEvent;

public interface AbstractFollowRelationCommandHandler {

    FollowRelationEvent handleFollow(UserID userID);

    UnfollowRelationEvent handleUnfollow(UserID userID);

    UnfollowRelationEvent handleRemove(UserID userID);
}
