package az.rock.flyjob.auth.dataAccess.repository;

import az.rock.flyjob.auth.dataAccess.entity.AuthenticationLogEntity;
import az.rock.flyjob.auth.dataAccess.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthenticationLogJPARepository extends JpaRepository<AuthenticationLogEntity, UUID> {
}

