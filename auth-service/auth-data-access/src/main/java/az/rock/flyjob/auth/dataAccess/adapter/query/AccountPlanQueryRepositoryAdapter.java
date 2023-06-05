package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAccountPlanDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.query.AccountPlanQueryJPARepository;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

@Component
public class AccountPlanQueryRepositoryAdapter implements AbstractAccountPlanQueryRepositoryAdapter {
    private final AccountPlanQueryJPARepository accountPlanJPARepository;
    private final AbstractAccountPlanDataAccessMapper<AccountPlanEntity,AccountPlanRoot> accountPlanDataAccessMapper;

    public AccountPlanQueryRepositoryAdapter(AccountPlanQueryJPARepository accountPlanJPARepository,
                                             AbstractAccountPlanDataAccessMapper<AccountPlanEntity, AccountPlanRoot> accountPlanDataAccessMapper) {
        this.accountPlanJPARepository = accountPlanJPARepository;
        this.accountPlanDataAccessMapper = accountPlanDataAccessMapper;
    }

    @Override
    public AccountPlanRoot findById(AccountPlanID rootId) {
        return null;
    }

    @Override
    public AccountPlanRoot findByPID(UserID parentID) {
        var entity = this.accountPlanJPARepository.findByUser(parentID.getUUID());
        var root = this.accountPlanDataAccessMapper.toRoot(entity);
        return root;
    }
}
