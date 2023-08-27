package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import com.intellibukcet.lib.payload.event.abstracts.AbstractDomainEvent;
import com.intellibukcet.lib.payload.event.abstracts.Event;

@Event
public class UpgradedAccountPlanEvent extends AbstractDomainEvent<AccountPlanRoot> {
    private UpgradedAccountPlanEvent(AccountPlanRoot root) {
        super(root);
    }

    public static UpgradedAccountPlanEvent of(AccountPlanRoot root) {
        return new UpgradedAccountPlanEvent(root);
    }
}
