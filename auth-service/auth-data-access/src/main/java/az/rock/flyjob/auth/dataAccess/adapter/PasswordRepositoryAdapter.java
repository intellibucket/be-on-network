package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractPasswordRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.PasswordDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.PasswordJPARepository;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import org.springframework.stereotype.Component;

@Component
public class PasswordRepositoryAdapter implements AbstractPasswordRepositoryAdapter {
    private final PasswordJPARepository passwordJPARepository;

    private final PasswordDataAccessMapper passwordDataAccessMapper;

    public PasswordRepositoryAdapter(PasswordJPARepository passwordJPARepository,
                                     PasswordDataAccessMapper passwordDataAccessMapper) {
        this.passwordJPARepository = passwordJPARepository;
        this.passwordDataAccessMapper = passwordDataAccessMapper;
    }

    @Override
    public PasswordRoot create(PasswordRoot root) {
        var entity = this.passwordDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.passwordJPARepository.save(entity);
        return this.passwordDataAccessMapper.toRoot(savedEntity);
    }
}
