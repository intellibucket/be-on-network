package az.rock.flyjob.auth.service.abstracts;

import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import az.rock.lib.valueObject.AccountPlanType;

public interface AbstractAccountPlanDomainService {
    void validateForUpgrade(AccountPlanRoot currentAccountPlan, AccountPlanType plan);
}
