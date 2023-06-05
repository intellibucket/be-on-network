package az.rock.flyjob.auth.dataAccess.repository.query;

import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserSettingsQueryJPARepository extends JpaRepository<UserSettingsEntity, UUID> {
    @Query("SELECT row FROM UserSettingsEntity row WHERE (:userId = row.user.uuid)")
    UserSettingsEntity findByUser(@Param(value = "userId") UUID userId);

    @Query("SELECT row FROM UserSettingsEntity row WHERE (:uuid = row.uuid)")
    UserSettingsEntity findByUuid(@Param(value = "uuid")UUID uuid);
}
