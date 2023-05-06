package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.mapper.AccountDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.account.AccountJPARepository;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryAdapter {
    private final AccountJPARepository accountJPARepository;

    private final AccountDataAccessMapper accountDataAccessMapper;

    public AccountRepositoryAdapter(AccountJPARepository accountJPARepository,
                                    AccountDataAccessMapper accountDataAccessMapper) {
        this.accountJPARepository = accountJPARepository;
        this.accountDataAccessMapper = accountDataAccessMapper;
    }
}
