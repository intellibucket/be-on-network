package az.rock.flyjob.auth.event.block;

import az.rock.flyjob.auth.root.network.BlockRelationRoot;
import az.rock.lib.event.AbstractDomainEvent;

public class UserUnblockedEvent  extends AbstractDomainEvent<BlockRelationRoot> {
    protected UserUnblockedEvent(BlockRelationRoot root) {
        super(root);
    }

    public static UserUnblockedEvent of(BlockRelationRoot root) {
        return new UserUnblockedEvent(root);
    }
}
