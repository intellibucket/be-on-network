package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractAccountPlanQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.model.entity.user.AccountPlanEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractAccountPlanDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.AccountPlanQueryJPARepository;
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
        var entity = this.accountPlanJPARepository.findById(rootId.getRootID()).orElse(null);
        return this.accountPlanDataAccessMapper.toRoot(entity);
    }

    @Override
    public Optional<AccountPlanRoot> findByPID(UserID parentID) {
        var entity = this.accountPlanJPARepository.findByUser(parentID.getRootID());
        return this.accountPlanDataAccessMapper.toRoot(entity);
    }
    @Override
    public List<AccountPlanRoot> findByPIDAndInActiveStatus(UserID parentID) {
        var entities = this.accountPlanJPARepository.findByUserAndInActiveRowStatus(parentID.getRootID());
        return entities.stream()
                .map(this.accountPlanDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<AccountPlanRoot> findAllByPIDAndActiveStatus(UserID parentID) {
        var entities = this.accountPlanJPARepository.findAllByUser(parentID.getRootID());
        return entities.stream()
                .map(this.accountPlanDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }

    @Override
    public List<AccountPlanRoot> findAllUnCompletedAccountPlanByPID(UserID parentID) {
        var entities = this.accountPlanJPARepository.findAllUnCompletedByUser(parentID.getRootID());
        return entities.stream()
                .map(this.accountPlanDataAccessMapper::toRoot)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .toList();
    }
}
