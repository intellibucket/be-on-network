package az.rock.flyjob.js.dataaccess.repository.abstracts.command.custom.detail;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.InterestEntity;
import az.rock.flyjob.js.dataaccess.repository.abstracts.GJpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface AbstractInterestCustomCommandJPARepository extends GJpaRepository<InterestEntity, UUID> {
}
