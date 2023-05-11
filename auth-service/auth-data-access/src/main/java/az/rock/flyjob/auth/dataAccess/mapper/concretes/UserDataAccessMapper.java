package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.UserRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

@Component
public class UserDataAccessMapper implements AbstractDataAccessMapper<UserEntity, UserRoot> {
    private final PasswordDataAccessMapper passwordDataAccessMapper;
    private final AccountDataAccessMapper accountDataAccessMapper;

    public UserDataAccessMapper(PasswordDataAccessMapper passwordDataAccessMapper,
                                AccountDataAccessMapper accountDataAccessMapper) {
        this.passwordDataAccessMapper = passwordDataAccessMapper;
        this.accountDataAccessMapper = accountDataAccessMapper;
    }

    @Override
    public UserRoot toRoot(UserEntity entity) {
        var accountRoot = this.accountDataAccessMapper.toRoot(entity.getAccount());
        var passwordRoot = this.passwordDataAccessMapper.toRoot(entity.getPasswordEntity());
        return UserRoot.Builder
                .builder()
                .id(UserID.of(entity.getUuid()))
                .createdDate(GDateTime.of(entity.getCreatedDate()))
                .modificationDate(GDateTime.of(entity.getLastModifiedDate()))
                .version(entity.getVersion())
                .processStatus(entity.getProcessStatus())
                .dataStatus(entity.getDataStatus())
                .key(entity.getKey())
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .username(entity.getUsername())
                .password(passwordRoot)
                .email(entity.getEmail())
                .account(accountRoot)
                .build();
    }

    @Override
    public UserEntity toEntity(UserRoot root) {
        return UserEntity.Builder
                .builder()
                .build();
    }

    @Override
    public UserEntity toNewEntity(UserRoot root) {
        return UserEntity.Builder
                .builder()
                .build();
    }
}

