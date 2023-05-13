package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.DetailEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.detail.DetailRoot;
import az.rock.lib.domain.id.DetailID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class AccountDataAccessMapper implements AbstractDataAccessMapper<DetailEntity, DetailRoot> {
    private final UserDataAccessMapper userDataAccessMapper;
    private final RoleDataAccessMapper roleDataAccessMapper;

    public AccountDataAccessMapper(UserDataAccessMapper userDataAccessMapper,
                                   RoleDataAccessMapper roleDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public DetailRoot toRoot(DetailEntity entity) {
        var roleRoots = entity.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toRoot)
                .collect(Collectors.toSet());
        return DetailRoot.Builder
                .builder()
                .accountID(DetailID.of(entity.getUuid()))
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .user(this.userDataAccessMapper.toRoot(entity.getUserEntity()))
                .roles(roleRoots)
                .build();
    }

    @Override
    public DetailEntity toEntity(DetailRoot root) {
        var userEntity = this.userDataAccessMapper.toEntity(root.getUserRoot());
        var roleEntities = root.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return DetailEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .userEntity(userEntity)
                .roles(roleEntities)
                .build();
    }

    @Override
    public DetailEntity toNewEntity(DetailRoot root) {
        var userEntity = this.userDataAccessMapper.toEntity(root.getUserRoot());
        var roleEntities = root.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return DetailEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .userEntity(userEntity)
                .roles(roleEntities)
                .build();
    }
}
