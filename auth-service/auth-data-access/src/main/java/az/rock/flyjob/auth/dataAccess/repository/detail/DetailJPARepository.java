package az.rock.flyjob.auth.dataAccess.repository.detail;

import az.rock.flyjob.auth.dataAccess.entity.DetailEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetailJPARepository extends JpaRepository<DetailEntity, UUID> {
}
