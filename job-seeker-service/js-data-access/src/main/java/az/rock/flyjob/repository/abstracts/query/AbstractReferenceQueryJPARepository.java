package az.rock.flyjob.repository.abstracts.query;

import az.rock.flyjob.model.entity.resume.details.AwardEntity;
import az.rock.flyjob.model.entity.resume.details.ReferenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractReferenceQueryJPARepository extends JpaRepository<ReferenceEntity, UUID> {
}
