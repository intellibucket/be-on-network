package az.rock.flyjob.auth.dataAccess.repository.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.FailOutboxEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface FailOutboxJPARepository extends JpaRepository<FailOutboxEntity, UUID> {
    @Query("SELECT f FROM FailOutboxEntity f WHERE f.transactionId = :transactionId and f.isActive = true")
    List<FailOutboxEntity> findByTransactionId(@Param("transactionId") UUID transactionId);
}
