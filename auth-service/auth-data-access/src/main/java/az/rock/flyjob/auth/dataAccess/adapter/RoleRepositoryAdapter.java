package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.repository.account.RoleJPARepository;
import org.springframework.stereotype.Component;

@Component
public class RoleRepositoryAdapter {
    private final RoleJPARepository roleJPARepository;

    public RoleRepositoryAdapter(RoleJPARepository roleJPARepository) {
        this.roleJPARepository = roleJPARepository;
    }
}
