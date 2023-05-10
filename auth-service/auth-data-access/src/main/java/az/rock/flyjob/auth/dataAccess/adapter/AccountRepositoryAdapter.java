package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractAccountRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.AccountDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.account.AccountJPARepository;
import az.rock.flyjob.auth.root.account.AccountRoot;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryAdapter implements AbstractAccountRepositoryAdapter {
    private final AccountJPARepository accountJPARepository;

    private final AccountDataAccessMapper accountDataAccessMapper;

    public AccountRepositoryAdapter(AccountJPARepository accountJPARepository,
                                    AccountDataAccessMapper accountDataAccessMapper) {
        this.accountJPARepository = accountJPARepository;
        this.accountDataAccessMapper = accountDataAccessMapper;
    }

    @Override
    public AccountRoot create(AccountRoot root) {
        var entity = this.accountDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.accountJPARepository.save(entity);
        return this.accountDataAccessMapper.toRoot(savedEntity);
    }
}
