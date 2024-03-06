package az.rock.flyjob.auth.dataAccess.repository.outbox;

import az.rock.flyjob.auth.dataAccess.model.entity.outbox.ProcessStepEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface ProcessStepJPARepository extends JpaRepository<ProcessStepEntity, UUID> {

    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN TRUE ELSE FALSE END FROM ProcessStepEntity p WHERE p.transactionId = :transactionId AND p.step = :step and p.isActive = true")
    Boolean existByTransactionIdAndStep(@Param("transactionId") UUID transactionId, @Param("step") String step);

    @Query("SELECT p FROM ProcessStepEntity p WHERE p.transactionId = :transactionId AND p.step IN :steps and p.isActive = true")
    List<ProcessStepEntity> findAllByTransactionIdInAllSteps(@Param("transactionId") UUID transactionId, List<String> steps);

    @Query("SELECT p FROM ProcessStepEntity p WHERE p.transactionId = :transactionId and p.isActive = true")
    List<ProcessStepEntity> findAllByTransactionId(@Param("transactionId") UUID transactionId);
}
