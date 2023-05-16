package az.rock.flyjob.auth.dataAccess.mapper.concretes;

import az.rock.flyjob.auth.dataAccess.entity.UserEntity;
import az.rock.flyjob.auth.dataAccess.mapper.abstracts.AbstractDataAccessMapper;
import az.rock.flyjob.auth.root.UserRoot;
import az.rock.lib.domain.id.UserID;
import az.rock.lib.util.GDateTime;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class UserDataAccessMapper implements AbstractDataAccessMapper<UserEntity, UserRoot> {
    private final PasswordDataAccessMapper passwordDataAccessMapper;
    private final DetailDataAccessMapper detailDataAccessMapper;

    public UserDataAccessMapper(PasswordDataAccessMapper passwordDataAccessMapper,
                                DetailDataAccessMapper detailDataAccessMapper) {
        this.passwordDataAccessMapper = passwordDataAccessMapper;
        this.detailDataAccessMapper = detailDataAccessMapper;
    }

    @Override
    public UserRoot toRoot(UserEntity entity) {
        var accountRoot = this.detailDataAccessMapper.toRoot(entity.getDetail());
        var passwordRoots = entity.getPasswordEntity().stream()
                .map(this.passwordDataAccessMapper::toRoot)
                .collect(Collectors.toSet());
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
                .password(passwordRoots)
                .account(accountRoot)
                .timezone(entity.getTimezone())
                .build();
    }

    @Override
    public UserEntity toEntity(UserRoot root) {
        var accountEntity = this.detailDataAccessMapper.toEntity(root.getAccount());
        var passwordEntitySet = root.getPasswords().stream()
                .map(this.passwordDataAccessMapper::toEntity)
                .collect(Collectors.toSet());
        return UserEntity.Builder
                .builder()
                .uuid(root.getUUID().getId())
                .createdDate(GDateTime.of(root.getCreatedDate()))
                .lastModifiedDate(GDateTime.of(root.getModificationDate()))
                .version(root.getVersion())
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .key(root.getKey())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .passwordEntity(passwordEntitySet)
                .account(accountEntity)
                .timezone(root.getTimezone())
                .build();
    }

    @Override
    public UserEntity toNewEntity(UserRoot root) {
        var accountEntity = this.detailDataAccessMapper.toNewEntity(root.getAccount());
        var passwordEntitySet = root.getPasswords().stream()
                .map(this.passwordDataAccessMapper::toNewEntity)
                .collect(Collectors.toSet());
        return UserEntity.Builder
                .builder()
                .uuid(UUID.randomUUID())
                .version(1L)
                .processStatus(root.getProcessStatus())
                .dataStatus(root.getDataStatus())
                .key(root.getKey())
                .firstName(root.getFirstName())
                .lastName(root.getLastName())
                .username(root.getUsername())
                .passwordEntity(passwordEntitySet)
                .account(accountEntity)
                .timezone(root.getTimezone())
                .build();
    }
}

