package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.account.AccountEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.account.AccountRoot;
import org.springframework.stereotype.Component;

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
        return AccountRoot.Builder
                .builder()
                .build();
    }

    @Override
    public AccountEntity toEntity(AccountRoot root) {
        return AccountEntity.Builder
                .builder()
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
