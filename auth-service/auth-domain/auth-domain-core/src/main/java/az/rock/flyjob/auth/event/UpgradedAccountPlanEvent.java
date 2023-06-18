package az.rock.flyjob.auth.event;

import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.event.AbstractDomainEvent;
import az.rock.lib.event.Event;

@Event
public class UpgradedAccountPlanEvent extends AbstractDomainEvent<AccountPlanRoot> {
    private UpgradedAccountPlanEvent(AccountPlanRoot root) {
        super(root);
    }

    public static UpgradedAccountPlanEvent of(AccountPlanRoot root) {
        return new UpgradedAccountPlanEvent(root);
    }
}
