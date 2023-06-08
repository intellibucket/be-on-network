package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.UserCommandJPARepository;
import az.rock.flyjob.auth.root.user.UserRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCommandRepositoryAdapter implements AbstractUserCommandRepositoryAdapter {
    private final UserCommandJPARepository userCommandJPARepository;

    private final UserDataAccessMapper userDataAccessMapper;

    public UserCommandRepositoryAdapter(UserCommandJPARepository userCommandJPARepository,
                                        UserDataAccessMapper userDataAccessMapper) {
        this.userCommandJPARepository = userCommandJPARepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public Optional<UserRoot> create(UserRoot root) {
        var entity = this.userDataAccessMapper.toNewEntity(root);
        if(entity.isPresent()) {
            var savedEntity = this.userCommandJPARepository.save(entity.get());
            return this.userDataAccessMapper.toRoot(savedEntity);
        }else return Optional.empty();
    }

}
