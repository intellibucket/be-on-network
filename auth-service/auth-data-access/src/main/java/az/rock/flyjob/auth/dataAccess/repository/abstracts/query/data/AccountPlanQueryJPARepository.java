package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data;

import az.rock.flyjob.auth.dataAccess.model.entity.user.AccountPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountPlanQueryJPARepository extends JpaRepository<AccountPlanEntity, UUID> {
    @Query("SELECT row FROM AccountPlanEntity row " +
            "WHERE (:userId = row.user.uuid) and (row.rowStatus = 'ACTIVE') and (row.processStatus = 'COMPLETED')")
    AccountPlanEntity findByUser(@Param(value = "userId") UUID userId);

    @Query("SELECT row FROM AccountPlanEntity row " +
            "WHERE (:userId = row.user.uuid) and (row.rowStatus = 'ACTIVE') and (row.processStatus = 'COMPLETED')")
    List<AccountPlanEntity> findAllByUser(@Param(value = "userId") UUID userId);

    @Query("SELECT row FROM AccountPlanEntity row " +
            "WHERE (:userId = row.user.uuid) and (row.rowStatus = 'ACTIVE') and row.processStatus <> 'COMPLETED'")
    List<AccountPlanEntity> findAllUnCompletedByUser(@Param(value = "userId") UUID userId);

    @Query("SELECT row FROM AccountPlanEntity row " +
            "WHERE (:userId = row.user.uuid) and row.rowStatus = 'INACTIVE' ")
    List<AccountPlanEntity> findByUserAndInActiveRowStatus(@Param(value = "userId") UUID userId);

}
