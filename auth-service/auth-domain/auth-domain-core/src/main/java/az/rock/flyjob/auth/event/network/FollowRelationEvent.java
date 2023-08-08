package az.rock.flyjob.auth.event.network;

import az.rock.flyjob.auth.root.network.FollowRelationRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class FollowRelationEvent extends AbstractDomainEvent<FollowRelationRoot> {

    protected FollowRelationEvent(FollowRelationRoot root) {
        super(root);
    }

    public static FollowRelationEvent of(FollowRelationRoot root) {
        return new FollowRelationEvent(root);
    }
}