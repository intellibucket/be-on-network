package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import com.intellibucket.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibucket.lib.payload.event.abstracts.Event;

@Event
public class UpgradedAccountPlanEvent extends AbstractDomainEvent<AccountPlanRoot> {
    private UpgradedAccountPlanEvent(AccountPlanRoot root) {
        super(root);
    }

    public static UpgradedAccountPlanEvent of(AccountPlanRoot root) {
        return new UpgradedAccountPlanEvent(root);
    }
}
