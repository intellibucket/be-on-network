package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.repository.account.AccountJPARepository;
import org.springframework.stereotype.Component;

@Component
public class AccountRepositoryAdapter {
    private final AccountJPARepository accountJPARepository;

    public AccountRepositoryAdapter(AccountJPARepository accountJPARepository) {
        this.accountJPARepository = accountJPARepository;
    }
}
