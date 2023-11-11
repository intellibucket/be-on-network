package az.rock.auth.domain.presentation.mapper.abstracts;

import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.auth.UserID;
import az.rock.lib.valueObject.AccountPlanType;

public interface AbstractAccountPlanDomainMapper {
    AccountPlanRoot freeAccountPlan(UserID userID);

    AccountPlanRoot createOnWaitingAccountPlan(UserID userID, AccountPlanType plan);
}
