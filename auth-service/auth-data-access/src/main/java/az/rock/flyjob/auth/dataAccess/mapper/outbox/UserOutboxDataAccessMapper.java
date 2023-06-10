package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.entity.outbox.UserOutboxEntity;
import az.rock.flyjob.auth.root.UserOutboxRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserOutboxDataAccessMapper implements AbstractUserOutboxDataAccessMapper{
    @Override
    public Optional<UserOutboxRoot> toRoot(UserOutboxEntity entity) {
        return Optional.empty();
    }

    @Override
    public Optional<UserOutboxEntity> toEntity(UserOutboxRoot root) {
        return Optional.empty();
    }

    @Override
    public Optional<UserOutboxEntity> toNewEntity(UserOutboxRoot root) {
        return Optional.empty();
    }
}
