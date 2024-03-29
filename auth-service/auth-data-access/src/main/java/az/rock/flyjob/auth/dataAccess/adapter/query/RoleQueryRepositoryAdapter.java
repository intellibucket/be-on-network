package az.rock.flyjob.auth.dataAccess.adapter.query;

import az.rock.auth.domain.presentation.ports.output.repository.query.AbstractRoleQueryRepositoryAdapter;
import az.rock.flyjob.auth.dataAccess.mapper.concretes.RoleDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data.RoleQueryJPARepository;
import az.rock.flyjob.auth.model.root.RoleRoot;
import az.rock.lib.domain.id.auth.*;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RoleQueryRepositoryAdapter implements AbstractRoleQueryRepositoryAdapter {
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
