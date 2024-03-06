package az.rock.flyjob.js.dataaccess.repository.abstracts.query.jpa;

import az.rock.flyjob.js.dataaccess.model.entity.resume.ResumeEntity;
import az.rock.flyjob.js.dataaccess.model.entity.resume.details.EducationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface EducationQueryJpaRepository extends JpaRepository<EducationEntity, UUID> {

    Optional<EducationEntity> findByResumeAndUuidAndRowStatusTrue(ResumeEntity resumeEntity, UUID educationId);
}
