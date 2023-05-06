package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.mapper.PasswordDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.PasswordJPARepository;
import org.springframework.stereotype.Component;

@Component
public class PasswordRepositoryAdapter {
    private final PasswordJPARepository passwordJPARepository;

    private final PasswordDataAccessMapper passwordDataAccessMapper;

    public PasswordRepositoryAdapter(PasswordJPARepository passwordJPARepository,
                                     PasswordDataAccessMapper passwordDataAccessMapper) {
        this.passwordJPARepository = passwordJPARepository;
        this.passwordDataAccessMapper = passwordDataAccessMapper;
    }
}
