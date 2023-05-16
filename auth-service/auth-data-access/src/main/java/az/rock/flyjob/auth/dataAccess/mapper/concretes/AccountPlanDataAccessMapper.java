package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.AccountPlanRoot;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanDataAccessMapper implements AbstractDataAccessMapper<AccountPlanEntity, AccountPlanRoot> {
    @Override
    public AccountPlanRoot toRoot(AccountPlanEntity entity) {
        return null;
    }

    @Override
    public AccountPlanEntity toEntity(AccountPlanRoot root) {
        return null;
    }

    @Override
    public AccountPlanEntity toNewEntity(AccountPlanRoot root) {
        return null;
    }
}
