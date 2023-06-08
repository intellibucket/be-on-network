package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractPasswordCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.PasswordDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.PasswordJPARepository;
import az.rock.flyjob.auth.root.user.PasswordRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class PasswordCommandRepositoryAdapter implements AbstractPasswordCommandRepositoryAdapter {
    private final PasswordJPARepository passwordJPARepository;

    private final PasswordDataAccessMapper passwordDataAccessMapper;

    public PasswordCommandRepositoryAdapter(PasswordJPARepository passwordJPARepository,
                                            PasswordDataAccessMapper passwordDataAccessMapper) {
        this.passwordJPARepository = passwordJPARepository;
        this.passwordDataAccessMapper = passwordDataAccessMapper;
    }

    @Override
    public Optional<PasswordRoot> create(PasswordRoot root) {
        var entity = this.passwordDataAccessMapper.toNewEntity(root);
        if(entity.isPresent()){
            var savedEntity  = this.passwordJPARepository.save(entity.get());
            return this.passwordDataAccessMapper.toRoot(savedEntity);
        }else return Optional.empty();
    }
}
