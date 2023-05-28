package az.rock.auth.domain.presentation.mapper.concretes;

import az.rock.auth.domain.presentation.mapper.abstracts.AbstractAccountPlanDomainMapper;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanDomainMapper implements AbstractAccountPlanDomainMapper {
    @Override
    public AccountPlanRoot freeAccountPlan(UserID userID) {
        return null;
    }
}
