package az.rock.flyjob.auth.dataAccess.adapter.command;

import az.rock.auth.domain.presentation.ports.output.repository.command.AbstractCommandRoleRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.RoleDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.command.RoleCommandJPARepository;
import az.rock.flyjob.auth.root.RoleRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleCommandRepositoryAdapter implements AbstractCommandRoleRepositoryAdapter {
    private final RoleCommandJPARepository roleJPARepository;

    private final RoleDataAccessMapper roleDataAccessMapper;

    public RoleCommandRepositoryAdapter(RoleCommandJPARepository roleJPARepository,
                                        RoleDataAccessMapper roleDataAccessMapper) {
        this.roleJPARepository = roleJPARepository;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public Optional<RoleRoot> create(RoleRoot root) {
        var entity = this.roleDataAccessMapper.toNewEntity(root);
        if (entity.isPresent()){
            var savedEntity = this.roleJPARepository.save(entity.get());
            return this.roleDataAccessMapper.toRoot(savedEntity);
        }else return Optional.empty();
    }
}
