package az.rock.flyjob.auth.dataAccess.repository.abstracts.command;

import az.rock.flyjob.auth.dataAccess.model.entity.detail.DetailEntity;
import az.rock.flyjob.auth.dataAccess.repository.abstracts.GJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DetailCommandJPARepository extends GJpaRepository<DetailEntity, UUID> {
}
