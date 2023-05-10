package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.account.AccountEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.account.AccountRoot;
import org.springframework.stereotype.Component;

@Component
public class AccountDataAccessMapper implements AbstractDataAccessMapper<AccountEntity, AccountRoot> {
    @Override
    public AccountRoot toRoot(AccountEntity entity) {
        return null;
    }

    @Override
    public AccountEntity toEntity(AccountRoot root) {
        return null;
    }

    @Override
    public AccountEntity toNewEntity(AccountRoot root) {
        return null;
    }
}
