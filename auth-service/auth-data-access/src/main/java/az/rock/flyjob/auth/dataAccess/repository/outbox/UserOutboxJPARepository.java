package az.rock.flyjob.auth.dataAccess.repository.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.UserOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserOutboxJPARepository extends JpaRepository<UserOutboxEntity, UUID>{
    @Query("select u from UserOutboxEntity u where u.sagaId = ?1")
    Optional<UserOutboxEntity> findBySagaId(UUID sagaId);
}
