package az.rock.flyjob.auth.dataAccess.repository.abstracts;

import az.rock.flyjob.auth.dataAccess.entity.user.device.AuthenticationLogEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthenticationLogJPARepository extends JpaRepository<AuthenticationLogEntity, UUID> {
}
