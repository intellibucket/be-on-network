package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.account.AuthorityEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.AuthorityRoot;
import az.rock.lib.domain.AggregateRoot;
import az.rock.lib.domain.BaseEntity;
import az.rock.lib.domain.id.AuthorityID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AuthorityDataAccessMapper implements AbstractDataAccessMapper<AuthorityEntity, AuthorityRoot> {
    private final RoleDataAccessMapper roleDataAccessMapper;



    public AuthorityDataAccessMapper(RoleDataAccessMapper roleDataAccessMapper) {
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public AuthorityRoot toRoot(AuthorityEntity entity) {
        var roleRoots = entity.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toRoot)
                .collect(Collectors.toSet());
        return AuthorityRoot.Builder
                .builder()
                .id(AuthorityID.of(entity.getUuid()))
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .permission(entity.getPermission())
                .description(entity.getDescription())
                .roles(roleRoots)
                .build();
    }

    @Override
    public AuthorityEntity toEntity(AuthorityRoot root) {
        var roleEntities = root.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return AuthorityEntity.Builder
                .builder()
                .uuid(root.getUUID().getUUID())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .description(root.getDescription())
                .permission(root.getPermission())
                .roles(roleEntities)
                .build();
    }

    @Override
    public AuthorityEntity toNewEntity(AuthorityRoot root) {
        var roleEntities = root.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toNewEntity)
                .collect(Collectors.toSet());
        return AuthorityEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .description(root.getDescription())
                .permission(root.getPermission())
                .roles(roleEntities)
                .build();
    }
}

