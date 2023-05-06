package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.flyjob.auth.dataAccess.mapper.RoleDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.account.RoleJPARepository;
import org.springframework.stereotype.Component;

@Component
public class RoleRepositoryAdapter {
    private final RoleJPARepository roleJPARepository;

    private final RoleDataAccessMapper roleDataAccessMapper;

    public RoleRepositoryAdapter(RoleJPARepository roleJPARepository,
                                 RoleDataAccessMapper roleDataAccessMapper) {
        this.roleJPARepository = roleJPARepository;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }
}
