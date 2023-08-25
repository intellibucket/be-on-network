package az.rock.flyjob.auth.event.network;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;

@Event
public class FollowRelationEvent extends AbstractDomainEvent<FollowRelationRoot> {

    protected FollowRelationEvent(FollowRelationRoot root) {
        super(root);
    }

    public static FollowRelationEvent of(FollowRelationRoot root) {
        return new FollowRelationEvent(root);
    }
}