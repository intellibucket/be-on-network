package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.repository.PasswordJPARepository;
import org.springframework.stereotype.Component;

@Component
public class PasswordRepositoryAdapter {
    private final PasswordJPARepository passwordJPARepository;

    public PasswordRepositoryAdapter(PasswordJPARepository passwordJPARepository) {
        this.passwordJPARepository = passwordJPARepository;
    }
}
