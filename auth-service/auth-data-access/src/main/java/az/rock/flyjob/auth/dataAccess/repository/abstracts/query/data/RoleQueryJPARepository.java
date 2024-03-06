package az.rock.flyjob.auth.dataAccess.repository.abstracts.query.data;

import az.rock.flyjob.auth.dataAccess.model.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface RoleQueryJPARepository extends JpaRepository<RoleEntity, UUID> {
    @Query("SELECT row FROM RoleEntity row WHERE (:name = row.name) " +
            " AND (row.rowStatus = 'ACTIVE')")
    RoleEntity findByName(@Param(value = "name") String name);
}
