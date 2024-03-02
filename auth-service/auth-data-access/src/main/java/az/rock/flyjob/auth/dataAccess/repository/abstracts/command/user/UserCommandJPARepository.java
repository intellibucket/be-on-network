package az.rock.flyjob.auth.dataAccess.repository.abstracts.command.user;

import az.rock.flyjob.auth.dataAccess.model.entity.user.UserEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.GJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserCommandJPARepository extends GJpaRepository<UserEntity, UUID> {
}
