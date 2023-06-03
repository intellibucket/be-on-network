package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractUserCommandRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.UserJPARepository;
import az.rock.flyjob.auth.root.user.UserRoot;
import org.springframework.stereotype.Component;

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
    public UserRoot create(UserRoot root) {
        var entity = this.userDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.userJPARepository.saveAndFlush(entity);
        return this.userDataAccessMapper.toRoot(savedEntity);
    }

}
