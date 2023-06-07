package az.rock.flyjob.auth.dataAccess.repository.query;

import az.rock.flyjob.auth.dataAccess.entity.user.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailQueryJPARepository extends JpaRepository<EmailEntity, UUID> {
}
