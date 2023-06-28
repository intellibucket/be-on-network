package az.rock.flyjob.auth.dataAccess.repository.abstracts.query;

import az.rock.flyjob.auth.dataAccess.entity.user.PasswordEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PasswordQueryJPARepository extends JpaRepository<PasswordEntity, UUID> {
    @Query("SELECT row FROM PasswordEntity row WHERE (:userId = row.user.uuid)" +
            " and (row.rowStatus = 'ACTIVE')")
    Optional<PasswordEntity> findByPID(@Param("userId") UUID pid);

    @Query("SELECT row FROM PasswordEntity row WHERE (:passId = row.uuid)" +
            " and (row.rowStatus = 'ACTIVE')")
    Optional<PasswordEntity> findById(@Param("passId") UUID passId);
}
