package az.rock.flyjob.auth.dataAccess.repository.query;

import az.rock.flyjob.auth.dataAccess.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface RoleQueryJPARepository extends JpaRepository<RoleEntity, UUID> {
    @Query("SELECT row FROM RoleEntity row WHERE (:name = row.name)")
    RoleEntity findByName(@Param(value = "name") String name);
}
