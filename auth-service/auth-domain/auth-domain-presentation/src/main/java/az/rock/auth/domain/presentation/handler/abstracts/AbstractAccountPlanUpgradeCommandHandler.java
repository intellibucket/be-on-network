package az.rock.auth.domain.presentation.handler.abstracts;

import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.lib.valueObject.AccountPlanType;

public interface AbstractAccountPlanUpgradeCommandHandler {
    UpgradedAccountPlanEvent handle(AccountPlanType plan);
}
