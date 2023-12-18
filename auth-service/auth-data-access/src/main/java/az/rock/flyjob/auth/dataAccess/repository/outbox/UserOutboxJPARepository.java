package az.rock.flyjob.auth.dataAccess.repository.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessOutboxEntity;

import java.util.Optional;
import java.util.UUID;

//@Repository
public interface UserOutboxJPARepository {
    //@Query("select u from ProcessOutboxEntity u where u.sagaId = ?1")
    Optional<ProcessOutboxEntity> findBySagaId(UUID sagaId);
}
