package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAccountPlanDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.query.AccountPlanQueryJPARepository;
import az.rock.flyjob.auth.root.user.AccountPlanRoot;
import az.rock.lib.domain.id.AccountPlanID;
import az.rock.lib.domain.id.UserID;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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
    public Optional<AccountPlanRoot> findById(AccountPlanID rootId) {
        var entity = this.accountPlanJPARepository.findById(rootId.getUUID()).orElse(null);
        return this.accountPlanDataAccessMapper.toRoot(entity);
    }

    @Override
    public Optional<AccountPlanRoot> findByPID(UserID parentID) {
        var entity = this.accountPlanJPARepository.findByUser(parentID.getUUID());
        return this.accountPlanDataAccessMapper.toRoot(entity);
    }
    @Override
    public Optional<AccountPlanRoot> findByPIDAndActiveStatus(UserID parentID) {
        var entity = this.accountPlanJPARepository.findByUserAndActiveRowStatus(parentID.getUUID());
        return this.accountPlanDataAccessMapper.toRoot(entity);
    }

    @Override
    public List<Optional<AccountPlanRoot>> findAllByPIDAndActiveStatus(UserID parentID) {
        var entities = this.accountPlanJPARepository.findAllByUserAndActiveRowStatus(parentID.getUUID());
        return entities.stream().map(this.accountPlanDataAccessMapper::toRoot).toList();
    }
}
