package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.mapper.UserDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.UserJPARepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter {
    private final UserJPARepository userJPARepository;

    private final UserDataAccessMapper userDataAccessMapper;

    public UserRepositoryAdapter(UserJPARepository userJPARepository,
                                 UserDataAccessMapper userDataAccessMapper) {
        this.userJPARepository = userJPARepository;
        this.userDataAccessMapper = userDataAccessMapper;
    }
}
