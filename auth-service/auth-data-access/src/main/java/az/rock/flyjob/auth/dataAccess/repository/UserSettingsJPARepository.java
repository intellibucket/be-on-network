package az.rock.flyjob.auth.dataAccess.repository;

import az.rock.flyjob.auth.dataAccess.entity.user.UserSettingsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserSettingsJPARepository extends JpaRepository<UserSettingsEntity, UUID> {
    @Query("SELECT row FROM UserSettingsEntity row WHERE (:userId = row.user.uuid)")
    UserSettingsEntity findByUser(@Param(value = "userId") UUID userId);
}
