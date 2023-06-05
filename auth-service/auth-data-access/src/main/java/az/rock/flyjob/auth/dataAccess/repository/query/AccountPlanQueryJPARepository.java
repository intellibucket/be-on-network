package az.rock.flyjob.auth.dataAccess.repository.query;

import az.rock.flyjob.auth.dataAccess.entity.user.AccountPlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountPlanQueryJPARepository extends JpaRepository<AccountPlanEntity, UUID> {
    @Query("SELECT row FROM AccountPlanEntity row WHERE (:userId = row.user.uuid)")
    AccountPlanEntity findByUser(@Param(value = "userId") UUID userId);
}
