package az.rock.flyjob.auth.dataAccess.repository.abstracts.command;

import az.rock.flyjob.auth.dataAccess.entity.AuthorityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AuthorityCommandJPARepository extends JpaRepository<AuthorityEntity, UUID> {
}
