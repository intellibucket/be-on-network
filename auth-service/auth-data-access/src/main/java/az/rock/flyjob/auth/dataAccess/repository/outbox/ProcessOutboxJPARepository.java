package az.rock.flyjob.auth.dataAccess.repository.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProcessOutboxJPARepository extends JpaRepository<ProcessOutboxEntity, UUID> {
    @Query("select u from ProcessOutboxEntity u where u.transactionId =:transactionId and u.isActive = true")
    Optional<ProcessOutboxEntity> findByTransactionId(@Param("transactionId") UUID transactionId);
}
