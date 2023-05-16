package az.rock.flyjob.auth.dataAccess.repository;

import az.rock.flyjob.auth.dataAccess.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleJPARepository extends JpaRepository<RoleEntity, UUID> {
}
