package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.account.RoleEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.account.RoleRoot;
import az.rock.lib.domain.id.RoleID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class RoleDataAccessMapper  implements AbstractDataAccessMapper<RoleEntity, RoleRoot> {
    private final AuthorityDataAccessMapper authorityDataAccessMapper;

    public RoleDataAccessMapper(AuthorityDataAccessMapper authorityDataAccessMapper) {
        this.authorityDataAccessMapper = authorityDataAccessMapper;
    }

    @Override
    public RoleRoot toRoot(RoleEntity entity) {
        var authorities = entity.getAuthorities()
                .stream()
                .map(this.authorityDataAccessMapper::toRoot)
                .collect(Collectors.toSet());
        return RoleRoot.Builder
                .builder()
                .roleID(RoleID.of(entity.getUuid()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .name(entity.getName())
                .description(entity.getDescription())
                .authorities(authorities)
                .build();
    }

    @Override
    public RoleEntity toEntity(RoleRoot root) {
        var authorities = root.getAuthorities()
                .stream()
                .map(this.authorityDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return RoleEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersion())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .name(root.getName())
                .description(root.getDescription())
                .authorities(authorities)
                .build();
    }

    @Override
    public RoleEntity toNewEntity(RoleRoot root) {
        var authorities = root.getAuthorities()
                .stream()
                .map(this.authorityDataAccessMapper::toNewEntity)
                .collect(Collectors.toSet());
        return RoleEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .name(root.getName())
                .description(root.getDescription())
                .authorities(authorities)
                .build();
    }
}
