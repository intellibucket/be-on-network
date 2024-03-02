package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractAccountPlanCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.AccountPlanDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.account.AbstractAccountPlanCommandJPARepository;
import az.rock.flyjob.auth.model.root.user.AccountPlanRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class AccountPlanCommandRepositoryAdapter implements AbstractAccountPlanCommandRepositoryAdapter {
    private final AbstractAccountPlanCommandJPARepository accountPlanCommandJPARepository;
    private final AccountPlanDataAccessMapper accountPlanDataAccessMapper;

    public AccountPlanCommandRepositoryAdapter(AbstractAccountPlanCommandJPARepository accountPlanCommandJPARepository,
                                               AccountPlanDataAccessMapper accountPlanDataAccessMapper) {
        this.accountPlanCommandJPARepository = accountPlanCommandJPARepository;
        this.accountPlanDataAccessMapper = accountPlanDataAccessMapper;
    }

    @Override
    public Optional<AccountPlanRoot> create(AccountPlanRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        var optionalEntity = this.accountPlanDataAccessMapper.toNewEntity(optionalRoot.get());
        if (optionalEntity.isPresent()) {
            var savedEntity = this.accountPlanCommandJPARepository.persistAndFlush(optionalEntity.get());
            return this.accountPlanDataAccessMapper.toRoot(savedEntity);
        }
        return Optional.empty();
    }

    @Override
    public void rollback(AccountPlanRoot root) {
        var optionalEntity = this.accountPlanDataAccessMapper.toEntity(root);
        optionalEntity.ifPresentOrElse(
                this.accountPlanCommandJPARepository::rollback,
                () -> log.error("User cannot rollback because of entity is null")
        );
    }
}
