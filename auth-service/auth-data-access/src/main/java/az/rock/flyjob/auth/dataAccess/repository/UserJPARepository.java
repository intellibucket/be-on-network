package az.rock.flyjob.auth.dataAccess.repository;

import az.rock.flyjob.auth.dataAccess.entity.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UserJPARepository extends JpaRepository<UserEntity, UUID> {
}
