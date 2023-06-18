package az.rock.flyjob.auth.service.concretes;

import az.rock.flyjob.auth.event.UpgradedAccountPlanEvent;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.flyjob.auth.service.abstracts.AbstractAccountPlanDomainService;
import az.rock.lib.valueObject.AccountPlanType;

public class AccountPlanDomainService implements AbstractAccountPlanDomainService {
    public UpgradedAccountPlanEvent validateAndInitializeAccountPlan(AccountPlanRoot accountPlanRoot, AccountPlanType plan) {
        return UpgradedAccountPlanEvent.of(accountPlanRoot);
    }

    @Override
    public void validateForUpgrade(AccountPlanRoot currentAccountPlan, AccountPlanType plan) {
        if (currentAccountPlan.getPlan().equals(plan)) throw new RuntimeException("F0000000020");
    }
}
