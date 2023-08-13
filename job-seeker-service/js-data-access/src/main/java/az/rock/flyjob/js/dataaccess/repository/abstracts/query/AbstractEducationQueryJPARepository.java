package az.rock.flyjob.js.dataaccess.repository.abstracts.query;

import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AbstractEducationQueryJPARepository extends JpaRepository<EducationEntity, UUID> {
}
