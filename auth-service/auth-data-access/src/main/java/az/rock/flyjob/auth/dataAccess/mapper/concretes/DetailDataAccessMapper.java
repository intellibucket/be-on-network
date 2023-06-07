package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.RoleEntity;
import az.rock.flyjob.auth.dataAccess.entity.detail.DetailEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDetailDataAccessMapper;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractRoleDataAccessMapper;
import az.rock.flyjob.auth.root.RoleRoot;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class DetailDataAccessMapper implements AbstractDetailDataAccessMapper<DetailEntity, DetailRoot> {

    private final AbstractRoleDataAccessMapper<RoleEntity, RoleRoot> roleDataAccessMapper;

    public DetailDataAccessMapper(AbstractRoleDataAccessMapper<RoleEntity, RoleRoot> roleDataAccessMapper) {
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public Optional<DetailRoot> toRoot(DetailEntity entity) {
        var optionalDetailEntity = Optional.ofNullable(entity);
        if (optionalDetailEntity.isEmpty()) return Optional.empty();
        return Optional.of(DetailRoot.Builder
                .builder()
                .detailID(DetailID.of(entity.getUuid()))
                .createdDate(GDateTime.toZonedDateTime(entity.getCreatedDate()))
                .modificationDate(GDateTime.toZonedDateTime(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .build());
    }

    @Override
    public Optional<DetailEntity> toEntity(DetailRoot root) {
        var optionalDetailRoot = Optional.ofNullable(root);
        if (optionalDetailRoot.isEmpty()) return Optional.empty();
        return Optional.of(DetailEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .version(root.getVersionValue())
                .build());
    }

    @Override
    public Optional<DetailEntity> toNewEntity(DetailRoot root) {
        var optionalDetailRoot = Optional.ofNullable(root);
        if (optionalDetailRoot.isEmpty()) return Optional.empty();
        var roleEntities = root.getRoles().stream()
                .map(this.roleDataAccessMapper::toEntity)
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toSet());
        var detailEntity =  Optional.of(DetailEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .version(root.getVersionValue())
                .processStatus(root.getProcessStatus())
                .rowStatus(root.getRowStatus())
                .roles(roleEntities)
                .createdDate(GDateTime.toTimestamp(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.toTimestamp(root.getModificationDate()))
                .isAccountNonExpired(root.isAccountNonExpired())
                .isAccountNonLocked(root.isAccountNonLocked())
                .isCredentialsNonExpired(root.isCredentialsNonExpired())
                .isEnabled(root.isEnabled())
                .isDeleted(root.isDeleted())
                .isFrozen(root.isFrozen())
                .build());
        roleEntities.forEach(roleEntity -> roleEntity.addDetailEntity(detailEntity.get()));
        return detailEntity;
    }
}
