package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.user;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCommandJPARepository extends JpaRepository<UserEntity, UUID> {
}
