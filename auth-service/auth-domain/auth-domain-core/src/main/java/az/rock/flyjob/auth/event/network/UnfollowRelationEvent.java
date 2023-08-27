package az.rock.flyjob.auth.event.network;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;


@Event
public class UnfollowRelationEvent extends AbstractDomainEvent<FollowRelationRoot> {
    protected UnfollowRelationEvent(FollowRelationRoot root) {
        super(root);
    }

    public static UnfollowRelationEvent of(FollowRelationRoot root) {
        return new UnfollowRelationEvent(root);
    }
}
