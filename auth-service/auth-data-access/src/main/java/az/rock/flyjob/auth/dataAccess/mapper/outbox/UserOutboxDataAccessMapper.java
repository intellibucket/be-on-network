package az.rock.flyjob.auth.dataAccess.mapper.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessOutboxEntity;
import az.rock.flyjob.auth.model.root.UserOutboxRoot;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class UserOutboxDataAccessMapper implements AbstractUserOutboxDataAccessMapper{
    @Override
    public Optional<UserOutboxRoot> toRoot(ProcessOutboxEntity entity) {
        var optionalEntity = Optional.ofNullable(entity);
        if (optionalEntity.isPresent()) {
            var outboxEntity = optionalEntity.get();
            return Optional.ofNullable(null);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProcessOutboxEntity> toEntity(UserOutboxRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()) {
            var outboxRoot = optionalRoot.get();
            return Optional.ofNullable(null);
        }
        return Optional.empty();
    }

    @Override
    public Optional<ProcessOutboxEntity> toNewEntity(UserOutboxRoot root) {
        var optionalRoot = Optional.ofNullable(root);
        if (optionalRoot.isPresent()) {
            var outboxRoot = optionalRoot.get();
            return Optional.ofNullable(null);
        }
        return Optional.empty();
    }
}
