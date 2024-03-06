package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractPasswordCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.PasswordDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.AbstractPasswordCommandJPARepository;
import az.rock.flyjob.auth.model.root.user.PasswordRoot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class PasswordCommandRepositoryAdapter implements AbstractPasswordCommandRepositoryAdapter {
    private final AbstractPasswordCommandJPARepository passwordCommandJPARepository;

    private final PasswordDataAccessMapper passwordDataAccessMapper;

    public PasswordCommandRepositoryAdapter(AbstractPasswordCommandJPARepository passwordCommandJPARepository,
                                            PasswordDataAccessMapper passwordDataAccessMapper) {
        this.passwordCommandJPARepository = passwordCommandJPARepository;
        this.passwordDataAccessMapper = passwordDataAccessMapper;
    }

    @Override
    public Optional<PasswordRoot> create(PasswordRoot root) {
        var entity = this.passwordDataAccessMapper.toNewEntity(root);
        if(entity.isPresent()){
            var savedEntity = this.passwordCommandJPARepository.persist(entity.get());
            return this.passwordDataAccessMapper.toRoot(savedEntity);
        } else return Optional.empty();
    }

    @Override
    public void inActive(PasswordRoot root) {
        var entity = this.passwordDataAccessMapper.toEntity(root);
        entity.ifPresent(this.passwordCommandJPARepository::inActive);
    }

    @Override
    public void rollback(PasswordRoot root) {
        var optionalEntity = this.passwordDataAccessMapper.toEntity(root);
        optionalEntity.ifPresentOrElse(
                this.passwordCommandJPARepository::rollback,
                () -> log.error("User cannot rollback because of entity is null")
        );
    }
}
