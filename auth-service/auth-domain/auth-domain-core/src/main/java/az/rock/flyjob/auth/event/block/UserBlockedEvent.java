package az.rock.flyjob.auth.event.block;

import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import az.rock.lib.event.AbstractDomainEvent;

public class UserBlockedEvent  extends AbstractDomainEvent<BlockRelationRoot> {
    protected UserBlockedEvent(BlockRelationRoot root) {
        super(root);
    }

    public static UserBlockedEvent of(BlockRelationRoot root) {
        return new UserBlockedEvent(root);
    }
}
