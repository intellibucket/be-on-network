package az.rock.flyjob.auth.dataAccess.adapter;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractCommandRoleRepositoryAdapter;
import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractQueryRoleRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.RoleDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.RoleJPARepository;
import az.rock.flyjob.auth.root.RoleRoot;
import org.springframework.stereotype.Component;

@Component
public class RoleCommandRepositoryAdapter implements AbstractCommandRoleRepositoryAdapter {
    private final RoleJPARepository roleJPARepository;

    private final RoleDataAccessMapper roleDataAccessMapper;

    public RoleCommandRepositoryAdapter(RoleJPARepository roleJPARepository,
                                        RoleDataAccessMapper roleDataAccessMapper) {
        this.roleJPARepository = roleJPARepository;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public RoleRoot create(RoleRoot root) {
        var entity = this.roleDataAccessMapper.toNewEntity(root);
        var savedEntity  = this.roleJPARepository.save(entity);
        return this.roleDataAccessMapper.toRoot(savedEntity);
    }
}
