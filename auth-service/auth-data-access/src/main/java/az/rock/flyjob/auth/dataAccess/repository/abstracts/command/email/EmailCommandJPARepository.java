package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.email;

import az.rock.flyjob.auth.dataAccess.model.entity.user.EmailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface EmailCommandJPARepository extends JpaRepository<EmailEntity, UUID> {
}
