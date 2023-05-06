package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.repository.UserJPARepository;
import org.springframework.stereotype.Component;

@Component
public class UserRepositoryAdapter {
    private final UserJPARepository userJPARepository;

    public UserRepositoryAdapter(UserJPARepository userJPARepository) {
        this.userJPARepository = userJPARepository;
    }
}
