package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.valueObject.AccountPlanType;

public interface AbstractAccountPlanDomainMapper {
    AccountPlanRoot freeAccountPlan(UserID userID);

    AccountPlanRoot createOnWaitingAccountPlan(UserID userID, AccountPlanType plan);
}
