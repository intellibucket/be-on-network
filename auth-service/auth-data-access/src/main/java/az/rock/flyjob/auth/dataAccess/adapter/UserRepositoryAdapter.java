package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.AbstractUserRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.UserJPARepository;
import az.rock.flyjob.auth.root.UserRoot;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter implements AbstractUserRepositoryAdapter {
    private final UserJPARepository userJPARepository;

    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryAdapter(UserJPARepository userJPARepository,
                                 UserDataAccessMapper userDataAccessMapper) {
        this.userJPARepository = userJPARepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }

    @Override
    public UserRoot create(UserRoot root) {
        var entity = this.userDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.userJPARepository.save(entity);
        return this.userDataAccessMapper.toRoot(savedEntity);
    }
}
