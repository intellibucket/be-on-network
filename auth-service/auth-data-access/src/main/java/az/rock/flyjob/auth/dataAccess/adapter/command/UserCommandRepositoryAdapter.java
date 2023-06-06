package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.UserJPARepository;
import az.rock.flyjob.auth.root.user.UserRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserCommandRepositoryAdapter implements AbstractUserCommandRepositoryAdapter {
    private final UserJPARepository userJPARepository;

    private final UserDataAccessMapper userDataAccessMapper;

    public UserCommandRepositoryAdapter(UserJPARepository userJPARepository,
                                        UserDataAccessMapper userDataAccessMapper) {
        this.userJPARepository = userJPARepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public Optional<UserRoot> create(UserRoot root) {
        var entity = this.userDataAccessMapper.toNewEntity(root);
        if(entity.isPresent()) {
            var savedEntity = this.userJPARepository.save(entity.get());
            return this.userDataAccessMapper.toRoot(savedEntity);
        }else return Optional.empty();
    }

}
