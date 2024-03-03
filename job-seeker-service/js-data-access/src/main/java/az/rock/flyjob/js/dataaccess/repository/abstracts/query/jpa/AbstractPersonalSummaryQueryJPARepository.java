package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.PersonalSummaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractPersonalSummaryQueryJPARepository extends JpaRepository<PersonalSummaryEntity, UUID> {
}
