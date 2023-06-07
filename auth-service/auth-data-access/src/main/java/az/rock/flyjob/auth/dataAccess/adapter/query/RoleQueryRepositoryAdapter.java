package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractQueryRoleRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.RoleDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.query.RoleQueryJPARepository;
import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.domain.id.RoleID;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleQueryRepositoryAdapter implements AbstractQueryRoleRepositoryAdapter {
    private final RoleQueryJPARepository roleQueryJPARepository;
    private final RoleDataAccessMapper roleDataAccessMapper;

    public RoleQueryRepositoryAdapter(RoleQueryJPARepository roleQueryJPARepository,
                                      RoleDataAccessMapper roleDataAccessMapper) {
        this.roleQueryJPARepository = roleQueryJPARepository;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public Optional<RoleRoot> findById(RoleID rootId) {
        return Optional.empty();
    }

    @Override
    public Optional<RoleRoot> findByPID(DetailID parentID) {
        return Optional.empty();
    }

    @Override
    public Optional<RoleRoot> findByName(String name) {
        var optionalRoleEntity = Optional.ofNullable(roleQueryJPARepository.findByName(name));
        if(optionalRoleEntity.isPresent()) return this.roleDataAccessMapper.toRoot(optionalRoleEntity.get());
        else return Optional.empty();
    }
}
