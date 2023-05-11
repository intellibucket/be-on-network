package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.account.AccountEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.account.AccountRoot;
import az.rock.lib.domain.id.AccountID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class AccountDataAccessMapper implements AbstractDataAccessMapper<AccountEntity, AccountRoot> {
    private final UserDataAccessMapper userDataAccessMapper;
    private final RoleDataAccessMapper roleDataAccessMapper;

    public AccountDataAccessMapper(UserDataAccessMapper userDataAccessMapper,
                                   RoleDataAccessMapper roleDataAccessMapper) {
        this.userDataAccessMapper = userDataAccessMapper;
        this.roleDataAccessMapper = roleDataAccessMapper;
    }

    @Override
    public AccountRoot toRoot(AccountEntity entity) {
        var roleRoots = entity.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toRoot)
                .collect(Collectors.toSet());
        return AccountRoot.Builder
                .builder()
                .accountID(AccountID.of(entity.getUuid()))
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .user(this.userDataAccessMapper.toRoot(entity.getUserEntity()))
                .roles(roleRoots)
                .build();
    }

    @Override
    public AccountEntity toEntity(AccountRoot root) {
        var userEntity = this.userDataAccessMapper.toEntity(root.getUserRoot());
        var roleEntities = root.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return AccountEntity.Builder
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
    public AccountEntity toNewEntity(AccountRoot root) {
        var userEntity = this.userDataAccessMapper.toEntity(root.getUserRoot());
        var roleEntities = root.getRoles()
                .stream()
                .map(this.roleDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return AccountEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .userEntity(userEntity)
                .roles(roleEntities)
                .build();
    }
}
